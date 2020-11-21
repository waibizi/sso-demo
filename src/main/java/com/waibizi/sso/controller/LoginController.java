package com.waibizi.sso.controller;

import com.waibizi.sso.domain.po.SysUser;
import com.waibizi.sso.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 歪鼻子
 * @Date 2020/11/21 13:31
 * @Description:
 * @Version 1.0
 */
@RestController
public class LoginController {
    @Autowired
    private SysUserService sysUserService;
    @PostMapping("/login")
    public String login(@RequestBody SysUser sysUser){
        if (sysUser == null || "".equals(sysUser.getUsername().trim()) || "".equals(sysUser.getPassword())){
            return "确认必填参数";
        }
        return sysUserService.login(sysUser.getUsername(),sysUser.getPassword());
    }

    @GetMapping("/user-info")
    public SysUser getUserInfo(){
        return sysUserService.getUserInfo();
    }

    @PostMapping("/user")
    public String addUser(){
        return "测试是否可以访问";
    }
}
