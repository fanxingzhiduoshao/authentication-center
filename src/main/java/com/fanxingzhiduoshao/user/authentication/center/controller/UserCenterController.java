package com.fanxingzhiduoshao.user.authentication.center.controller;


import com.fanxingzhiduoshao.user.authentication.center.bean.Code;
import com.fanxingzhiduoshao.user.authentication.center.controller.bean.AjaxResult;
import com.fanxingzhiduoshao.user.authentication.center.controller.vo.UserAddVO;
import com.fanxingzhiduoshao.user.authentication.center.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@Api
@RequestMapping()
public class UserCenterController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/user/index");

        return mv;
    }
/*

    @GetMapping(name = "user", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation("获取用户列表")
    public AjaxResult getUser() {


        return AjaxResult.SUCCESSS;
    }
*/

    @PostMapping(name = "user", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation("注册用户")
    public AjaxResult addUser(@RequestBody UserAddVO userAddVO) {
        userService.addUser(userAddVO);
        return AjaxResult.SUCCESSS;
    }

    @GetMapping(name = "user/unique")
    public AjaxResult checkUnique(@RequestParam(required = false, defaultValue = "") String accountName,
                                  @RequestParam(required = false, defaultValue = "") String mail,
                                  @RequestParam(required = false, defaultValue = "") String phonenumber) {

        boolean unique = false;

        if (StringUtils.isNotBlank(accountName)) {
            unique = userService.isAccountNameUnique(accountName);
        }
        if (StringUtils.isNotBlank(mail)) {
            unique = userService.isMailUnique(mail);
        }
        if (StringUtils.isNotBlank(phonenumber)) {
            unique = userService.isPhonenumberUnique(phonenumber);
        }

        return AjaxResult.instance(Code.SUCCESS).setData(unique);
    }



/*

    @PutMapping(name = "user", produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxResult updateUser() {

        return AjaxResult.SUCCESSS;
    }
*/


}
