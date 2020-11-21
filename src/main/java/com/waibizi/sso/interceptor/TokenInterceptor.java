package com.waibizi.sso.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 歪鼻子
 * @Date 2020/11/21 14:40
 * @Description:
 * @Version 1.0
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 检查用户是否持有令牌访问
        if (request.getHeader("token") != null){
            // 校验令牌是否有效
            return redisTemplate.opsForValue().get(request.getHeader("token")) != null;
        }

        return false;
    }
}
