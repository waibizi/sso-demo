package com.waibizi.sso.service.impl;

import com.waibizi.sso.domain.po.SysUser;
import com.waibizi.sso.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Action;
import java.util.UUID;

/**
 * @Author 歪鼻子
 * @Date 2020/11/21 13:46
 * @Description:
 * @Version 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUser sysUser;
    @Autowired
     private RedisTemplate<String,Object> redisTemplate;
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public String login(String username,String password) {
        if (sysUser.getUsername().equals(username) && sysUser.getPassword().equals(password)){
            String token = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set(token,sysUser);
            return token;
        }
        return null;
    }
    /**
     * 获取用户信息
     * @return
     */
    @Override
    public SysUser getUserInfo() {
        // RequestContextHolder这玩意挺好玩的，有兴趣的同学一定要查查，这个封装成自己业务的request可以节省很多代码量
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        // 获取servlet上下文的request
        HttpServletRequest request = requestAttributes.getRequest();
        return (SysUser) redisTemplate.opsForValue().get(request.getHeader("token"));
    }


}
