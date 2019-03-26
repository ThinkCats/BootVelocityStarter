package com.busi.state.persist;

import com.busi.state.enums.StatusEnum;
import com.busi.state.enums.StatusEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.persist.AbstractPersistingStateMachineInterceptor;
import org.springframework.statemachine.persist.StateMachineRuntimePersister;
import org.springframework.statemachine.support.StateMachineInterceptor;
import org.springframework.stereotype.Component;

/**
 * @author WangLei
 * on 2019/3/26
 */
@Slf4j
@Component
public class StatePersister extends AbstractPersistingStateMachineInterceptor<StatusEnum, StatusEvent, String> implements StateMachineRuntimePersister<StatusEnum, StatusEvent, String> {

    @Autowired
    private StatePersis statePersis;

    @Override
    public void write(StateMachineContext<StatusEnum, StatusEvent> stateMachineContext, String aLong) throws Exception {
        log.info("---> Write");
        statePersis.write(stateMachineContext, aLong);
    }

    @Override
    public StateMachineContext<StatusEnum, StatusEvent> read(String aLong) throws Exception {
        log.info("---> Read:{}",aLong);
        return statePersis.read(aLong);
    }

    @Override
    public StateMachineInterceptor<StatusEnum, StatusEvent> getInterceptor() {
        return this;
    }

}
