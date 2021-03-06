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
import com.huilong.utils.MockUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 设置数据到 model 中，一般用于页面数据渲染
 *
 * @author daocr
 * @date 2021/1/21
 */
@Controller
@RequestMapping("/springmvc/model")
public class ModelController {


    /**
     * 方式 1 ：返回数据到  ViewResolver
     *
     * @param id
     * @param name
     * @param modelMap
     * @return
     */
    @GetMapping("/populate-model_v1")
    @Operation(description = "ModelMap 扭转数据")
    public String populateModel(@RequestParam Integer id, @RequestParam String name, ModelMap modelMap) {

        Staff staff = MockUtils.mockDynamic();
        staff.setName(name);

        modelMap.addAttribute("person", staff);
        modelMap.addAttribute("type", "ModelMap 扭转数据");
//        return modelAndView;
        return "annotated/model";
    }


    /**
     * 方式 2 ：返回数据到  ViewResolver
     *
     * @param id
     * @param name
     * @return
     */
    @GetMapping("/populate-model_v2")
    @Operation(description = "ModelAndView 扭转数据")
    public ModelAndView populateModel(@RequestParam Integer id, @RequestParam String name) {

        Staff person = new Staff();
        person.setId(id);
        person.setName(name);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("annotated/model");
        modelAndView.addObject("person", person);
        modelAndView.addObject("type", "ModelAndView 扭转数据");

        return modelAndView;
    }

}
