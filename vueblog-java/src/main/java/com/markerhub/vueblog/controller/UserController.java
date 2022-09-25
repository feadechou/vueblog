package com.markerhub.vueblog.controller;


import com.markerhub.vueblog.common.lang.Result;
import com.markerhub.vueblog.entity.User;
import com.markerhub.vueblog.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author local
 * @since 2022-08-15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Result test(){
        User user=userService.getById(1);
        return Result.succ(user);
    }

    @GetMapping("/save")
    public Result save(@Validated @RequestBody User user){
        return Result.succ(user);
    }

}
