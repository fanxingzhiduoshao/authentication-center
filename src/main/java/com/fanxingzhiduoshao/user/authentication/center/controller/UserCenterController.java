package com.fanxingzhiduoshao.user.authentication.center.controller;


import com.fanxingzhiduoshao.user.authentication.center.controller.vo.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/user")
public class UserCenterController {

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/user/index");

        return mv;
    }

    @GetMapping(name = "", produces = "application/json;charset=utf-8")
    public AjaxResult addUser() {

        return AjaxResult.SUCCESSS;
    }

    @PostMapping(name = "", produces = "application/json;charset=utf-8")
    public AjaxResult updateUser() {

        return AjaxResult.SUCCESSS;
    }


}
