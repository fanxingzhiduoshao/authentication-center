package com.fanxingzhiduoshao.user.authentication.center.controller;


import com.fanxingzhiduoshao.user.authentication.center.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Api
public class UserCenterController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/user/index");

        return mv;
    }

}
