package com.byron.eva.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Description:
 *
 * @Author: fanmingtao
 * @Date: 2019/4/3
 */
@Configuration
public class EvaWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private EvaInterceptor evaInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(evaInterceptor)
                .addPathPatterns("api/**")
                .excludePathPatterns("api/login");
    }
}
