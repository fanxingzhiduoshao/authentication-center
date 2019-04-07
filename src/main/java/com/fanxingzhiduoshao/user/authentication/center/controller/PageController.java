package com.fanxingzhiduoshao.user.authentication.center.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("page")
public class PageController {

    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("page/login");

        return mv;
    }

    @GetMapping("account_book")
    public ModelAndView account_book() {
        ModelAndView mv = new ModelAndView("page/account_book");

        return mv;
    }


}
