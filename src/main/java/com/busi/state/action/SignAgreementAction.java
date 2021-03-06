package com.busi.state.action;

import com.busi.state.enums.StatusEnum;
import com.busi.state.enums.StatusEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

/**
 * @author WangLei
 * on 2018/6/24
 */

@Slf4j
@Component
public class SignAgreementAction implements Action<StatusEnum,StatusEvent> {

    @Override
    public void execute(StateContext<StatusEnum, StatusEvent> stateContext) {
        log.info("DO Sign Agreement Start");
        StatusEvent event = stateContext.getEvent();
        StatusEnum sourceStatus = stateContext.getSource().getId();
        StatusEnum targetStatus = stateContext.getTarget().getId();
        log.info("event :" + event.toString());
        log.info("source status:" + sourceStatus.toString());
        log.info("target status:" + targetStatus.toString());
    }
}
