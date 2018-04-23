package com.fanxingzhiduoshao.user.authentication.center.controller.vo;

import lombok.Data;
import lombok.NonNull;

import javax.validation.Valid;

@Data
public class UserVO {
    @NonNull
    private String accountName;
    @NonNull
    private String password;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String email;
}
