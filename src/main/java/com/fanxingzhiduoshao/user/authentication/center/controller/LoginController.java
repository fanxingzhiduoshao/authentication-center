package com.fanxingzhiduoshao.user.authentication.center.controller;


import com.fanxingzhiduoshao.user.authentication.center.bean.Code;
import com.fanxingzhiduoshao.user.authentication.center.controller.bean.AjaxResult;
import com.fanxingzhiduoshao.user.authentication.center.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login")
@Api(description = "登录")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("login/index");

        return mv;
    }


    @PostMapping(produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxResult login(@RequestParam String name,
                            @RequestParam String password) {

        boolean isSuccess = userService.checkPassword(name, password);
        if (!isSuccess) {
            return AjaxResult.instance(Code.WRONG_NAME_PASSWORD_MISMATCH);

        }
        return AjaxResult.SUCCESSS;
    }


}
