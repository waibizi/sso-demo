package com.waibizi.sso.service;

import com.waibizi.sso.domain.po.SysUser;

/**
 * @Author 歪鼻子
 * @Date 2020/11/21 13:46
 * @Description:
 * @Version 1.0
 */
public interface SysUserService {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);

    /**
     * 获取用户信息
     * @return
     */
    SysUser getUserInfo();
}
