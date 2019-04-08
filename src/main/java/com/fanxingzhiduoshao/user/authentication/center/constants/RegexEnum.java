package com.fanxingzhiduoshao.user.authentication.center.constants;

/**
 * @author Created by star9264 on 2019/4/2
 */
public enum  RegexEnum {

    /**
     *
     */
    ACCOUNT_NAME("","",""),
    ;

    private String regex;
    private String description;
    private String remark;

    RegexEnum(String s, String s1, String s2) {
    }

    public String getRegex() {
        return regex;
    }

    public String getDescription() {
        return description;
    }

    public String getRemark() {
        return remark;
    }
}
