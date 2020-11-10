package com.liujx.testfront.controller;

import com.liujx.testfront.common.lang.Result;
import com.liujx.testfront.dao.LoginDao;
import com.liujx.testfront.entity.Login;
import com.liujx.testfront.service.LoginService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

@RestController
@Api(value = "测试接口Controller",tags = "测试接口Controller")
public class LoginController {
    @Autowired
    LoginService loginService;

   /* @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用戶名",dataType = "String",required = true, paramType = "form"),
            @ApiImplicitParam(name = "password",value = "密碼",dataType = "String",required = true, paramType = "form"),

    })*/

    @ApiOperation(value = "login")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result result(
//            @ApiParam(value = "m-z")
            @RequestBody Login login
    ){
        Boolean flag = loginService.loginConfirm(login.getUsername(),login.getPassword());
        if (flag){
            return Result.succ();
        }else{
            return Result.fail();
        }
    }
}
