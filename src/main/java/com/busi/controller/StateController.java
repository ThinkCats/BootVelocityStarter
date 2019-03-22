package com.busi.controller;

import com.busi.domain.vo.Result;
import com.busi.service.state.OrderService;
import com.busi.state.enums.StatusEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author WangLei
 * on 2018/6/24
 */
@Slf4j
@Controller
@RequestMapping("/state")
public class StateController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/init")
    @ResponseBody
    public Result init() {
        orderService.create();
        return Result.success("order init success");
    }

    @RequestMapping("/sign/{type}/{orderId}")
    @ResponseBody
    public Result sign(@PathVariable("type") String type,
                      @PathVariable("orderId") Long orderId) {
        orderService.signAgree(orderId, type);
        return Result.success("Sign Success");
    }

    @RequestMapping("/pay/{type}/{orderId}")
    @ResponseBody
    public Result pay(@PathVariable("type") String type,
                      @PathVariable("orderId") Long orderId) {
        orderService.pay(orderId, type);
        return Result.success("Sign Success");
    }



}
