package com.busi.config;

import com.busi.state.enums.StatusEnum;
import com.busi.state.enums.StatusEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.statemachine.data.jpa.JpaPersistingStateMachineInterceptor;
import org.springframework.statemachine.data.jpa.JpaStateMachineRepository;
import org.springframework.statemachine.persist.StateMachineRuntimePersister;

/**
 * @author WangLei
 * on 2019/3/26
 */
@Configuration
@Profile("jpa")
public class JpaPersisterConfig {

    @Bean
    public StateMachineRuntimePersister<StatusEnum, StatusEvent, Long> stateMachineRuntimePersister(JpaStateMachineRepository jpaStateMachineRepository) {
        return new JpaPersistingStateMachineInterceptor<>(jpaStateMachineRepository);
    }
}
