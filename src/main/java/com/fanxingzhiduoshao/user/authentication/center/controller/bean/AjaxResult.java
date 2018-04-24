package com.fanxingzhiduoshao.user.authentication.center.controller.bean;



import com.fanxingzhiduoshao.user.authentication.center.bean.Code;
import lombok.*;
import java.io.Serializable;


@Getter
@Setter
@RequiredArgsConstructor
public class AjaxResult implements Serializable {
    public final static AjaxResult SUCCESSS = new AjaxResult(200,"访问成功");
    public final static AjaxResult ERROR = new AjaxResult(500,"程序发生未知错误");

    public static AjaxResult instance(Code code){

        return new AjaxResult(code.getCode(),code.getMsg());
    }

    @NonNull
    private int code;
    @NonNull
    private String msg;
    private Object data;

    @Setter(AccessLevel.NONE)
    private boolean success;
    @Setter(AccessLevel.NONE)
    private boolean error;


    public boolean isSuccess(){
        return code==200;
    }
    public boolean isError(){
        return !isSuccess();
    }

    public AjaxResult setData(Object data) {
        this.data = data;
        return this;
    }
}
