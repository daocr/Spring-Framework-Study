package com.huilong.chapter1.service.impl;

import com.huilong.chapter1.LogAspect;
import com.huilong.chapter1.service.HelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Override
    @LogAspect("来源 HelloServiceImpl")
    public void SayHello(String name) {

        log.info("你好：{}", name);

    }
}