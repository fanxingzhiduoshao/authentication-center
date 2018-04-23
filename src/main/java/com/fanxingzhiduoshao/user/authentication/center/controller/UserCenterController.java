package com.fanxingzhiduoshao.user.authentication.center.controller;


import com.fanxingzhiduoshao.user.authentication.center.controller.service.UserService;
import com.fanxingzhiduoshao.user.authentication.center.controller.vo.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@Api
@RequestMapping("/user")
public class UserCenterController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/user/index");

        return mv;
    }

    @GetMapping(name = "", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation("获取用户列表")
    public AjaxResult getUser() {


        return AjaxResult.SUCCESSS;
    }

    @PostMapping(name = "", produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxResult addUser() {
        userService.addUser();
        return AjaxResult.SUCCESSS;
    }

    @PutMapping(name = "", produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxResult updateUser() {

        return AjaxResult.SUCCESSS;
    }


}
