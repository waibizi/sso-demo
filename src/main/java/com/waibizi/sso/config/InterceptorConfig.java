package com.waibizi.sso.config;

import com.waibizi.sso.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 歪鼻子
 * @Date 2020/11/21 14:45
 * @Description:
 * @Version 1.0
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    /**
     * 采用注入的方式是为了解决TokenInterceptor当中无法进行@Autowired的原因
     * 如果每次我们都采用一个新的即new TokenInterceptor(),我们是无法进行注入操作的
     */
    @Autowired
    private TokenInterceptor tokenInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
    }
}
