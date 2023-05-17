package com.notes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    // addResourceHandler: 访问映射路径
    // addResourceLocations: 资源绝对路径
    @Value("${file.basePath}")
    private String basePath;

    // 添加图片资源虚拟路径映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/imgFile/**").addResourceLocations("file:"+ basePath);
    }
}
