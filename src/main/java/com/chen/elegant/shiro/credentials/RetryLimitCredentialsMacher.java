package com.chen.elegant.shiro.credentials;

import com.chen.elegant.commom.SessionConst;
import com.chen.elegant.entity.TbUserAdmin;
import com.chen.elegant.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * 密码输入错误的状态下重试次数的匹配管理
 */
@Slf4j
public class RetryLimitCredentialsMacher extends CredentialsMatcher {
    /**
     * 用户登录次数计数  redisKey 前缀
     */
    private static final String SHIRO_LOGIN_COUNT = "shiro_login_count_";
    /**
     * 用户登录是否被锁定    一小时 redisKey 前缀
     */
    private static final String SHIRO_IS_LOCK = "shiro_is_lock_";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        TbUserAdmin shiroUser = (TbUserAdmin) info.getPrincipals().getPrimaryPrincipal();
        Integer userId = shiroUser.getAdminUserId();
        TbUserAdmin user = userService.findById(userId);
        String username = user.getLoginUserName();
        //用户访问一次，计数一次(设置两个key：一个是用户登录次数key，一个是用户锁定key)
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String loginCountKey = SHIRO_LOGIN_COUNT + username;
        String isLockKey = SHIRO_IS_LOCK + username;
        opsForValue.increment(loginCountKey,1);

        if (redisTemplate.hasKey(isLockKey)){
            throw new ExcessiveAttemptsException("帐号[" + username + "]已被禁止登录！");
        }

        //计数大于5时，设置用户被锁定一小时
        String loginCount = String.valueOf(opsForValue.get(loginCountKey));
        int retryCount = (5 - Integer.parseInt(loginCount));
        if (retryCount <= 0) {
            opsForValue.set(isLockKey, "LOCK");
            redisTemplate.expire(isLockKey, 1, TimeUnit.HOURS);
            redisTemplate.expire(loginCountKey, 1, TimeUnit.HOURS);
            throw new ExcessiveAttemptsException("由于密码输入错误次数过多，帐号[" + username + "]已被禁止登录！");
        }

        boolean matches = super.doCredentialsMatch(token, info);
        if (!matches) {
            String msg = retryCount <= 0 ? "您的账号一小时内禁止登录！" : "您还剩" + retryCount + "次重试的机会";
            throw new AccountException("帐号或密码不正确！" + msg);
        }

        //清空登录计数
        redisTemplate.delete(loginCountKey);

        //更新用户登录信息

        // 当验证都通过后，把用户信息放在session里
        // 注：User必须实现序列化
        SecurityUtils.getSubject().getSession().setAttribute(SessionConst.USER_SESSION_KEY, user);

        return true;
    }
}
