package com.fanxingzhiduoshao.user.authentication.center.controller;

import com.fanxingzhiduoshao.user.authentication.center.bean.Code;
import com.fanxingzhiduoshao.user.authentication.center.controller.bean.AjaxResult;
import com.fanxingzhiduoshao.user.authentication.center.controller.vo.AccountAddVO;
import com.fanxingzhiduoshao.user.authentication.center.service.AccountBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by star9264 on 2019/4/2
 */
@Controller
@RequestMapping("account_book")
@Api(description = "记账本")
@ResponseBody
public class AccountBookController {

    @Resource
    private AccountBookService accountBookService;

    @PostMapping(value = "account", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation("创建账户")
    public AjaxResult addAccount(@RequestBody AccountAddVO accountAddVO) {
        System.out.println("账户信息："+accountAddVO.toString());
        accountBookService.addAccount(accountAddVO.getName(),accountAddVO.getDescription());
        return AjaxResult.SUCCESSS;
    }

    @GetMapping(value = "account/{uid}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation("查询账户")
    public AjaxResult getAccount(@PathVariable("uid") String uid) {
        System.out.println("账户信息："+uid);
        return AjaxResult.instanceSuccess(accountBookService.getAccount(uid));
    }

    @GetMapping(value = "account?page={page}&size={size}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation("查询账户")
    public AjaxResult getAccounts(@PathVariable("page") int page,
                                 @PathVariable("size") int size) {
        System.out.println("账户信息："+page+size);
        return AjaxResult.instanceSuccess(accountBookService.getAccount());
    }

    @GetMapping(value = "account", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation("查询账户")
    public AjaxResult getAccount() {
        return AjaxResult.instanceSuccess(accountBookService.getAccount());
    }


}
