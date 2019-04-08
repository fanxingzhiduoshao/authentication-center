package com.fanxingzhiduoshao.user.authentication.center.util;

import java.util.UUID;

/**
 * @author Created by star9264 on 2019/4/2
 */
public class UUIDutils {

    private UUIDutils(){

    }

    public static String generateUUID32(){
        return UUID.randomUUID().toString().replace("-", "");
    }


}
