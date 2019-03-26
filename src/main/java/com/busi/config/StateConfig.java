package com.busi.config;

import com.busi.state.action.OrderActions;
import com.busi.state.enums.StatusEnum;
import com.busi.state.enums.StatusEvent;
import com.busi.state.persist.StatePersister;
import java.util.EnumSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.StateMachineRuntimePersister;
import org.springframework.statemachine.service.DefaultStateMachineService;
import org.springframework.statemachine.service.StateMachineService;

/**
 * @author WangLei
 * on 2018/6/23
 */
@Configuration
@EnableStateMachineFactory(name = "purchaseStateFactory")
public class StateConfig extends EnumStateMachineConfigurerAdapter<StatusEnum, StatusEvent> {

//    @Autowired
//    private StatePersister statePersister;

    @Autowired
    private OrderActions orderActions;

    //加载所需的状态信息
    @Override
    public void configure(StateMachineStateConfigurer<StatusEnum, StatusEvent> states) throws Exception {
        states.withStates()
                .initial(StatusEnum.INIT)
                .end(StatusEnum.WAIT_CONFIRM)
                .states(EnumSet.allOf(StatusEnum.class))
        ;
    }

    //状态流程
    @Override
    public void configure(StateMachineTransitionConfigurer<StatusEnum, StatusEvent> transitions) throws Exception {
        transitions
                .withExternal()
                .source(StatusEnum.INIT)
                .target(StatusEnum.WAIT_SIGN_AGREEMENT)
                .event(StatusEvent.CREATE)
                .action(orderActions)
                .and()
                .withExternal()
                .source(StatusEnum.WAIT_SIGN_AGREEMENT)
                .target(StatusEnum.WAIT_PAID)
                .event(StatusEvent.SIGN_AGREEMENT)
                .and()
                .withExternal()
                .source(StatusEnum.WAIT_PAID)
                .target(StatusEnum.WAIT_CONFIRM)
                .event(StatusEvent.PAY);
    }

}
