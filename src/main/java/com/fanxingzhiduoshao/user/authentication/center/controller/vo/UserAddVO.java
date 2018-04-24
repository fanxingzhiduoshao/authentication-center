package com.fanxingzhiduoshao.user.authentication.center.controller.vo;

import com.fanxingzhiduoshao.user.authentication.center.constants.RegexConstant;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


@Data
@NoArgsConstructor
public class UserAddVO {
    @NonNull @Pattern(regexp= RegexConstant.REGEX_ACCOUNT_NAME,message = RegexConstant.REGEX_ACCOUNT_NAME_MESSAGE)
    private String accountName;
    @NonNull @Pattern(regexp= RegexConstant.REGEX_PASSWORD,message = RegexConstant.REGEX_PASSWORD_MESSAGE)
    private String password;
    @NonNull @Pattern(regexp= RegexConstant.REGEX_PHONENUMBER,message = RegexConstant.REGEX_PHONENUMBER_MESSAGE)
    private String phoneNumber;
    @NonNull
    @Email
    private String mail;

}
