package com.fanxingzhiduoshao.user.authentication.center.controller.service;

import com.fanxingzhiduoshao.user.authentication.center.controller.entity.User;
import com.fanxingzhiduoshao.user.authentication.center.controller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(){
        User user = new User();
        user.setAccountName("wang");
        user.setCreateTime(new Date());
        user.setMail("871481270@qq.com");
        user.setPassword("wang");
        user.setPhoneNumber("18550475885");
        userRepository.save(user);

    }



}
