package com.busi.controller;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author WangLei
 * on 2019/6/28
 */
@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody
    HttpEntity<String> get() {
        return new HttpEntity<>("hello");
    }
}
