package com.huilong.chapter8;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

/**
 * 环境隔离
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter8App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.huilong.chapter8");

        /**
         * 激活环境
         * 1、代码激活
         * 2、命令行参数激活 -Dspring.profiles.active="profile1,profile2"
         */

        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        environment.addActiveProfile("dev");


        // 1、获取激活环境
        String[] activeProfiles = environment.getActiveProfiles();
        log.info("目前激活的环境有：{}", activeProfiles);


        annotationConfigApplicationContext.refresh();

        // 关闭容器
        annotationConfigApplicationContext.close();

    }

}