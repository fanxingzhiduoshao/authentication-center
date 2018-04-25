package com.fanxingzhiduoshao.user.authentication.center.controller;

import com.fanxingzhiduoshao.user.authentication.center.bean.Code;
import com.fanxingzhiduoshao.user.authentication.center.bean.ValidateCode;
import com.fanxingzhiduoshao.user.authentication.center.controller.bean.AjaxResult;
import com.fanxingzhiduoshao.user.authentication.center.controller.vo.UserAddVO;
import com.fanxingzhiduoshao.user.authentication.center.service.UserService;
import com.fanxingzhiduoshao.user.authentication.center.util.ValidateCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@Api(description = "注册")
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;


    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/register/index");

        return mv;
    }

    @PostMapping(value = "", produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation("注册用户")
    public AjaxResult addUser(@RequestBody UserAddVO userAddVO) {
        userService.addUser(userAddVO);
        return AjaxResult.SUCCESSS;
    }


    public AjaxResult addUserByMail() {

        return AjaxResult.SUCCESSS;
    }

    public AjaxResult addUserByPhone() {

        return AjaxResult.SUCCESSS;
    }


    @PostMapping(value = "/validate_code")
    @ApiOperation("获取验证码")
    public void getVarificationCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ValidateCode validateCode = ValidateCodeUtil.instance();
        response.setContentType("image");


        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
       /* response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);*/

        HttpSession session = request.getSession();

        session.setAttribute("code", validateCode.getCode());
        System.out.println("code=" + validateCode.getCode());

        OutputStream outputStream = response.getOutputStream();
        validateCode.write(outputStream);
        outputStream.close();
        return;
    }

    @GetMapping(value = "/validate_code", produces = "application/json;charset=utf-8")
    @ResponseBody
    public AjaxResult checkValidateCode(HttpServletRequest request,
                                        @RequestParam(required = false, defaultValue = "") String code) {
        boolean correct = false;

        HttpSession session = request.getSession();
        String correctCode = (String) session.getAttribute("code");
        System.out.println("code=" + code + " correctCode=" + correctCode);
        if (StringUtils.isNotBlank(code)) {
            correct = StringUtils.equals(code, correctCode);
        }

        return AjaxResult.instance(Code.SUCCESS).setData(correct);
    }


    @GetMapping(value = "/unique")
    @ResponseBody
    @ApiOperation("唯一性检查")
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

}
