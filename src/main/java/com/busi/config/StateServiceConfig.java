package com.busi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachineRuntimePersister;
import org.springframework.statemachine.service.DefaultStateMachineService;
import org.springframework.statemachine.service.StateMachineService;

/**
 * @author WangLei
 * on 2019/3/26
 */
@Configuration
public class StateServiceConfig {

    @Autowired
    private StateMachineRuntimePersister stateMachineRuntimePersister;
    @Autowired
    private StateMachineFactory stateMachineFactory;

    @Bean
    public StateMachineService stateMachineService() {
        return new DefaultStateMachineService(stateMachineFactory, stateMachineRuntimePersister);
    }

}
