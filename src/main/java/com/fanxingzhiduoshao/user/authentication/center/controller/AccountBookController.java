package com.fanxingzhiduoshao.user.authentication.center.controller;

import com.fanxingzhiduoshao.user.authentication.center.controller.bean.AjaxResult;
import com.fanxingzhiduoshao.user.authentication.center.controller.vo.AccountAddVO;
import com.fanxingzhiduoshao.user.authentication.center.controller.vo.AccountUpdateVO;
import com.fanxingzhiduoshao.user.authentication.center.service.AccountBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Created by star9264 on 2019/4/2
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
        System.out.println("addAccount："+accountAddVO.toString());
        accountBookService.addAccount(accountAddVO.getName(),accountAddVO.getDescription());
        return AjaxResult.SUCCESSS;
    }

    @PutMapping(value = "account/{uid}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation("修改账户")
    public AjaxResult updateAccount(@PathVariable("uid") String uid,
                                    @RequestBody AccountUpdateVO accountUpdateVO) {
        System.out.println("updateAccount："+uid);
        accountBookService.updateCount(uid,accountUpdateVO);
        return AjaxResult.SUCCESSS;
    }

    @GetMapping(value = "account/{uid}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation("查询账户")
    public AjaxResult getAccount(@PathVariable("uid") String uid) {
        System.out.println("getAccount："+uid);
        return AjaxResult.instanceSuccess(accountBookService.getAccount(uid));
    }

    @DeleteMapping(value = "account/{uid}", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation("删除账户")
    public AjaxResult deleteAccount(@PathVariable("uid") String uid) {
        System.out.println("deleteAccount："+uid);
        accountBookService.deleteAccount(uid);
        return AjaxResult.SUCCESSS;
    }

    @GetMapping(value = "accounts", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation("分页查询账户列表")
    public AjaxResult getAccounts(@RequestParam("page") int page,
                                 @RequestParam("size") int size) {
        System.out.println("账户信息："+page+size);
        return AjaxResult.instanceSuccess(accountBookService.listAccount(page,size));
    }




}
