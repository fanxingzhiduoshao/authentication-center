package com.fanxingzhiduoshao.user.authentication.center.controller.service;

import com.fanxingzhiduoshao.user.authentication.center.controller.entity.User;
import com.fanxingzhiduoshao.user.authentication.center.controller.repository.UserRepository;
import com.fanxingzhiduoshao.user.authentication.center.controller.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserVO userVO){
        User user = new User();
        user.setCreateTime(new Date());
        user.setAccountName(userVO.getAccountName());
        user.setPassword(userVO.getPassword());
        user.setMail(userVO.getEmail());
        user.setPhoneNumber(userVO.getPhoneNumber());
        userRepository.save(user);

    }



}
