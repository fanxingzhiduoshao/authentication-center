package com.fanxingzhiduoshao.user.authentication.center.service;

import com.fanxingzhiduoshao.user.authentication.center.bean.Code;
import com.fanxingzhiduoshao.user.authentication.center.entity.User;
import com.fanxingzhiduoshao.user.authentication.center.repository.UserRepository;
import com.fanxingzhiduoshao.user.authentication.center.controller.vo.UserAddVO;
import com.fanxingzhiduoshao.user.authentication.center.service.exception.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserAddVO userAddVO){
        if (!isAccountNameUnique(userAddVO.getAccountName())){
            throw new UserServiceException(Code.WRONG_ACCOUNT_NAME_EXIST);
        }
        if (!isMailUnique(userAddVO.getMail())){
            throw new UserServiceException(Code.WRONG_MAIL_EXIST);
        }
        if (!isPhonenumberUnique(userAddVO.getPhoneNumber())){
            throw new UserServiceException(Code.WRONG_PHONENUMBER_EXIST);
        }
        User user = new User();
        user.setCreateTime(new Date());
        user.setAccountName(userAddVO.getAccountName());
        user.setPassword(userAddVO.getPassword());
        user.setMail(userAddVO.getMail());
        user.setPhoneNumber(userAddVO.getPhoneNumber());
        userRepository.save(user);

    }

    public boolean isAccountNameUnique(String accountName){

        boolean exist = userRepository.existsByAccountName(accountName);

        return !exist;
    }

    public boolean isPhonenumberUnique(String phonenumber){
        boolean exist = userRepository.existsByPhonenumber(phonenumber);

        return !exist;
    }

    public boolean isMailUnique(String mail){
        boolean exist = userRepository.existsByMail(mail);

        return !exist;
    }




}
