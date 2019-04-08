package com.fanxingzhiduoshao.user.authentication.center.controller;

import com.fanxingzhiduoshao.user.authentication.center.bean.Code;
import com.fanxingzhiduoshao.user.authentication.center.controller.bean.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("file")
@Api(description = "文档上传/下载")
public class FileController {

    @GetMapping(value = "/unique")
    @ResponseBody
    @ApiOperation("唯一性检查")
    public AjaxResult checkUnique(MultipartFile file,
            @RequestParam(required = false, defaultValue = "") String accountName,
                                  @RequestParam(required = false, defaultValue = "") String mail,
                                  @RequestParam(required = false, defaultValue = "") String phonenumber) {

        boolean unique = false;


        return AjaxResult.instance(Code.SUCCESS).setData(unique);
    }
}
