package com.chen.elegant.service;

import com.chen.elegant.entity.TbUserAdmin;
import com.chen.elegant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public TbUserAdmin findByAccount(String account){
        return userRepository.findByLoginUserName(account);
    }

    public TbUserAdmin findById(Integer id){
        return userRepository.findByAdminUserId(id);
    }
}
