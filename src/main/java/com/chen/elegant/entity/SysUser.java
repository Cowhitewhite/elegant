package com.chen.elegant.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class SysUser implements Serializable {

    private static final long serialVersionUID = 9079093901981562621L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, length = 32)
    private String uid;// 用户id;

    @Column(unique = true, length = 30)
    private String username;// 登录账号.

    @Column(length = 30)
    private String name;// 名称

    @Column(length = 11)
    private String mobile;

    @Column(length = 32)
    private String password; // 密码;

    @Column(length = 32)
    private String salt;// 加密密码的盐

    @Column(columnDefinition="int default 1",length = 1)
    private int state;// 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.

    @Transient
    private List<SysRole> roles;

    @Transient
    private List<SysPermission> permissions;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
    /**
     * 密码盐.
     */
    public String getCredentialsSalt() {
        return this.username + this.salt;
    }

    public SysUser(String username, String name, String mobile, String password) {
        super();
        this.username = username;
        this.name = name;
        this.mobile = mobile;
        this.password = password;
    }
    public SysUser() {
        super();
    }
}