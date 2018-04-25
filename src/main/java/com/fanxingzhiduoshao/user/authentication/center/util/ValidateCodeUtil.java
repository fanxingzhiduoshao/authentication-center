package com.fanxingzhiduoshao.user.authentication.center.util;


import com.fanxingzhiduoshao.user.authentication.center.bean.ValidateCode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ValidateCodeUtil {


    private ValidateCodeUtil(){

    }

    AtomicInteger atomicInteger = new AtomicInteger(0);

    private static final Map<Integer,String> codeMap = new ConcurrentHashMap();

    public static ValidateCode instance(){
        ValidateCode validateCode = new ValidateCode();
        return validateCode;
    }

}
