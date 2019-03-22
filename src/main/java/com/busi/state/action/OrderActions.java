package com.busi.state.action;

import com.busi.state.enums.StatusEnum;
import com.busi.state.enums.StatusEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @author WangLei
 * on 2018/6/24
 */
@Slf4j
@WithStateMachine(id = "purchaseState")
public class OrderActions {

    @OnTransition(source = "INIT", target = "WAIT_SIGN_AGREEMENT")
    public void start() {
        log.info("Start Begin, Wait Sign Agreement");
    }

    @OnTransition(source = "WAIT_SIGN_AGREEMENT", target = "WAIT_PAID")
    public void signAgree(StateContext<StatusEnum, StatusEvent> stateContext) {
        log.info("Sign Agree ....");
        StatusEvent event = stateContext.getEvent();
        StatusEnum sourceStatus = stateContext.getSource().getId();
        StatusEnum targetStatus = stateContext.getTarget().getId();
        log.info("event :" + event.toString());
        log.info("source status:" + sourceStatus.toString());
        log.info("target status:" + targetStatus.toString());
    }

}
