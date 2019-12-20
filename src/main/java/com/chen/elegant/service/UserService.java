package com.chen.elegant.service;

import com.chen.elegant.entity.User;
import com.chen.elegant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByAccount(String account){
        return userRepository.findByUserName(account);
    }

    public User findById(Integer id){
        return userRepository.findById(id);
    }
}
