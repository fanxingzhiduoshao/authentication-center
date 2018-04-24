package com.fanxingzhiduoshao.user.authentication.center.bean;

import lombok.Data;
import lombok.NonNull;

@Data
public class Code {
    public static final Code SUCCESS = new Code(200,"访问成功");
    public static final Code ERROR = new Code(500,"程序发生未知错误");

    public static final Code WRONG_ACCOUNT_NAME_EXIST = new Code(500,"该用户名已存在!");
    public static final Code WRONG_PHONENUMBER_EXIST = new Code(500,"该电话号已被使用");
    public static final Code WRONG_MAIL_EXIST = new Code(500,"该邮箱已使用");

    @NonNull
    private int code;
    @NonNull
    private String msg;
}
