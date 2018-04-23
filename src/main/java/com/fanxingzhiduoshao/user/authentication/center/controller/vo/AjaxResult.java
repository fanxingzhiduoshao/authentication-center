package com.fanxingzhiduoshao.user.authentication.center.controller.vo;



import lombok.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class AjaxResult implements Serializable {
    public final static AjaxResult SUCCESSS = new AjaxResult(200,"访问成功");

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
    public boolean isErroe(){
        return !isSuccess();
    }


}
