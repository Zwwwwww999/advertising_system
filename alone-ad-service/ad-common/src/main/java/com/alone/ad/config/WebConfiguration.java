package com.alone.ad.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @ClassName WebConfiguration
 * @Author zzzzwwwwwwwwwwwwww
 * @Date 2021/2/21 20:30
 * @Description WebConfiguration
 * @Version 1.0
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
       // 清空消息转换器
        converters.clear();

        converters.add(new MappingJackson2HttpMessageConverter());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST","GET","PUT","DELETE","OPTIONS")
                .allowedOrigins("*");

    }
}
