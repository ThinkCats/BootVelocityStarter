package com.busi.controller;

import com.busi.domain.vo.Result;
import com.busi.service.event.TestEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author WangLei
 * on 2018/2/9
 */
@Slf4j
@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private TestEventService testEventService;

    @RequestMapping("/mail")
    @ResponseBody
    public Result doEvent() {
        testEventService.doSomethingBeforeSendEmail();
        return new Result(true, "OK");
    }
}
