package com.fanxingzhiduoshao.user.authentication.center.service;

import com.fanxingzhiduoshao.user.authentication.center.bean.Code;
import com.fanxingzhiduoshao.user.authentication.center.controller.vo.UserAddVO;
import com.fanxingzhiduoshao.user.authentication.center.entity.User;
import com.fanxingzhiduoshao.user.authentication.center.repository.UserRepository;
import com.fanxingzhiduoshao.user.authentication.center.service.exception.UserServiceException;
import lombok.NonNull;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
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
        //密码采用md5二次加密，服务端加密一次，浏览器加密一次
        user.setPassword(getEncrytPassword(userAddVO.getPassword()));
        user.setMail(userAddVO.getMail());
        user.setPhoneNumber(userAddVO.getPhoneNumber());
        userRepository.save(user);

    }

    public void addUserByPhone(){

    }

    public void addUserByMail(){

    }

    public void addUserByAccountName(){

    }


    public boolean isAccountNameUnique(String accountName){

        boolean exist = userRepository.existsByAccountName(accountName);

        return !exist;
    }

    public boolean isPhonenumberUnique(String phonenumber){
        boolean exist = userRepository.existsByPhoneNumber(phonenumber);

        return !exist;
    }

    public boolean isMailUnique(String mail){
        boolean exist = userRepository.existsByMail(mail);

        return !exist;
    }


    public boolean checkPassword(@NonNull String name,@NonNull String password) {
        boolean exist = false;
        User user = null;
        exist = userRepository.existsByAccountName(name);
        if (exist){
            user = userRepository.findByAccountName(name);
        }
        exist = userRepository.existsByPhoneNumber(name);
        if (exist){
            user = userRepository.findByPhoneNumber(name);
        }
        exist = userRepository.existsByMail(name);
        if (exist){
            user = userRepository.findByMail(name);
        }
        if (user!=null){
            String encrypt_password = getEncrytPassword(password);
            boolean isCorrect = StringUtils.equals(encrypt_password,user.getPassword());
            return isCorrect;
        }

        return false;
    }

    private String getEncrytPassword(String password) {
        return DigestUtils.md5Hex(password);
    }
}
