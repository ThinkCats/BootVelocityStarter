package com.busi.state.persist;

import com.busi.state.enums.StatusEnum;
import com.busi.state.enums.StatusEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.stereotype.Component;

/**
 * @author WangLei
 * on 2019/3/26
 */
@Slf4j
@Component
public class StatePersis implements StateMachinePersist<StatusEnum, StatusEvent, String> {

    @Override
    public void write(StateMachineContext<StatusEnum, StatusEvent> stateMachineContext, String bizId) throws Exception {
        log.info("--------------> Start Write State Info ");
        StatusEvent event = stateMachineContext.getEvent();
        log.info("Event : {}", event);
    }

    @Override
    public StateMachineContext<StatusEnum, StatusEvent> read(String bizId) throws Exception {
        log.info("<-------------- Start Read State Info ");
        log.info("Biz Id:{}", bizId);
        return null;
    }
}
