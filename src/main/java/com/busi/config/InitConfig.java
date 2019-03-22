package com.busi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

/**
 * @author WangLei
 * on 2018/6/24
 */
@Component
@Order(value = 1)
public class InitConfig implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //DO Something after spring startup
    }
}
