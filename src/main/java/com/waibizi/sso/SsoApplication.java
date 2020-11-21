package com.waibizi.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author 歪鼻子
 * @Date 2020/11/20 20:42
 * @Description:
 * @Version 1.0
 */
@EnableConfigurationProperties
@SpringBootApplication
public class SsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class,args);
    }
}
