package com.notes.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 存放项目相关的Bean对象
 * */
// @Component
public class ConfigBean {

    @Value("${file.uploadPath}")
    String uploadPath;

    /**项目路劲*/
    @Bean
    public String projectPath(){
        ApplicationHome h = new ApplicationHome(getClass());
        String dirPath = h.getSource().getParentFile().getParentFile().toString();
        return dirPath;
    }

    @Bean
    public String filePath(){
        ApplicationHome h = new ApplicationHome(getClass());
        String dirPath = h.getSource().getParentFile().getParentFile().toString();
        return dirPath+"\\src\\main\\resources\\"+uploadPath;
    }
}
