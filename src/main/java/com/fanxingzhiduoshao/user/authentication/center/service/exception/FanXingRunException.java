package com.fanxingzhiduoshao.user.authentication.center.service.exception;

import com.fanxingzhiduoshao.user.authentication.center.bean.Code;

public class FanXingRunException extends RuntimeException{
    private Code code;
    public FanXingRunException(Code code){
        super(code.getMsg());
        this.code = code;
    }
    public FanXingRunException(Code code, Throwable cause){
        super(code.getMsg(),cause);
        this.code = code;
    }

    public FanXingRunException() {
        super();
    }

    public FanXingRunException(String message) {
        super(message);
    }

    public FanXingRunException(String message, Throwable cause) {
        super(message, cause);
    }

    public FanXingRunException(Throwable cause) {
        super(cause);
    }

    protected FanXingRunException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
