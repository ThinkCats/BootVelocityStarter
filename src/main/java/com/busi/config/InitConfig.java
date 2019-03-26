package com.busi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author WangLei
 * on 2018/6/24
 */
@Slf4j
@Component
@Order(value = 1)
public class InitConfig implements ApplicationRunner {

//    @Resource(name = "purchaseState")
//    private StateMachine<StatusEnum, StatusEvent> stateMachine;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //DO Something after spring startup
//        log.info("=======> start state machine");
//        stateMachine.start();
    }
}
