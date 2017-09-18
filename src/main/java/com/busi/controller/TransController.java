package com.busi.controller;

import com.busi.service.trans.TransService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/trans")
public class TransController {
    @Autowired
    private TransService transService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    HttpEntity<String> get() {
        transService.doSomethingWithTransaction();
        return new HttpEntity<>("hello");
    }
}
