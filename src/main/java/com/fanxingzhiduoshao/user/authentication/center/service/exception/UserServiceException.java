package com.fanxingzhiduoshao.user.authentication.center.service.exception;

import com.fanxingzhiduoshao.user.authentication.center.bean.Code;

public class UserServiceException extends FanXingRunException {
    public UserServiceException(Code code) {
        super(code);
    }

    public UserServiceException(Code code, Throwable cause) {
        super(code, cause);
    }
}
