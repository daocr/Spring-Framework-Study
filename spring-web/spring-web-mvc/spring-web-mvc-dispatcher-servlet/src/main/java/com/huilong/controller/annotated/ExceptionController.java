/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-web-mvc-dispatcher-servlet Maven Webapp
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.controller.annotated;

import com.huilong.model.bo.Staff;
import com.huilong.model.bo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 异常处理
 *
 * @author daocr
 * @date 2021/1/21
 */
@Slf4j
@RestControllerAdvice
@Api(tags = "异常处理")
@RequestMapping("/springmvc/exception")
public class ExceptionController {

    /**
     * 跳转到首页
     *
     * @return
     */
    @GetMapping("/to-index")
    public String toIndex() {
        return "annotated/exception";
    }


    /**
     * 捕获  NumberFormatException
     *
     * @return
     */
    @ApiOperation(value = "触发 NumberFormatException 异常")
    @GetMapping("trigger-number-format-exception")
    @ResponseBody
    public R<Staff> triggerNumberFormatException(@ApiIgnore NumberFormatException e) {
        throw new NumberFormatException("触发 NumberFormatException 异常");
    }


    /**
     * 捕获  NumberFormatException
     * <p>
     * 入参支持类型
     *
     * @param numberFormatException 捕捉到异常的类型 {@link NumberFormatException}
     * @param handlerMethod         抛出异常的 controller method {@link HandlerMethod}
     * @param webRequest            对 Servlet API 的封装，避免直接只是用Servlet API  {@link WebRequest}
     * @param nativeWebRequest      对 Servlet API 的封装，避免直接只是用Servlet API  {@link NativeWebRequest}
     * @param servletRequest        ServletRequest   请求  {@link ServletRequest}
     * @param servletResponse       ServletResponse  响应  {@link ServletResponse}
     * @param httpSession           会话信息 HttpSession  {@link HttpSession}
     * @param httpMethod            请求方式 例如 get，post {@link HttpMethod}
     * @param locale                地区 {@link Locale}
     * @param timeZone              时区 {@link ZoneId}
     * @param zoneId                时区 {@link ZoneId}
     * @param redirectAttributes    从定向参数信息 {@link RedirectAttributes}
     * @return
     */
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public R numberFormatException(NumberFormatException numberFormatException,
                                   HandlerMethod handlerMethod,
                                   WebRequest webRequest,
                                   NativeWebRequest nativeWebRequest,
                                   ServletRequest servletRequest,
                                   ServletResponse servletResponse,
                                   HttpSession httpSession,
                                   HttpMethod httpMethod,
                                   Locale locale,
                                   TimeZone timeZone,
                                   ZoneId zoneId,
                                   RedirectAttributes redirectAttributes) {

        log.info("捕捉到的异常,params:" + "numberFormatException:" + numberFormatException + "," + "handlerMethod:" + handlerMethod + "," + "webRequest:" + webRequest + "," + "nativeWebRequest:" + nativeWebRequest + "," + "servletRequest:" + servletRequest + "," + "servletResponse:" + servletResponse + "," + "httpSession:" + httpSession + "," + "httpMethod:" + httpMethod + "," + "locale:" + locale + "," + "timeZone:" + timeZone + "," + "zoneId:" + zoneId + "," + "redirectAttributes:" + redirectAttributes);

        return R.failure("request method : " + httpMethod, "捕捉到 NumberFormatException");
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public R<Object> MethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {

        List<ObjectError> allErrors = methodArgumentNotValidException.getAllErrors();


        return R.failure(allErrors, "参数错误");
    }


}
