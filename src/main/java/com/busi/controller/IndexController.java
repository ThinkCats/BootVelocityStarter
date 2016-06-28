package com.busi.controller;

import com.busi.service.TestAopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wanglei25 on 2016/4/7.
 */
@Slf4j
@RequestMapping("/")
@Controller
public class IndexController {

    @Autowired
    private TestAopService testAopService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String home(){
        testAopService.testAop();
        System.out.println("test!!?");
        return "index";
    }
}
