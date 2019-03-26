package com.busi.service.state;

import com.busi.domain.OrderRepository;
import com.busi.domain.Orders;
import com.busi.state.enums.StatusEnum;
import com.busi.state.enums.StatusEvent;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.service.StateMachineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author WangLei
 * on 2018/6/24
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private StateMachineService<StatusEnum, StatusEvent> stateMachine;
    @Autowired
    private OrderRepository orderRepository;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void create() {
        Orders order = new Orders();
        order.setStatus(StatusEnum.INIT.name());
        order.setDateCreate(new Date());
        orderRepository.save(order);
        log.info("Save Biz Info Over,Send Event");
        this.sendEvent(StatusEvent.CREATE);
    }

    @Override
    public void signAgree(Long orderId, String type) {
        log.info("Read Current:");
        this.sendEvent(StatusEvent.SIGN_AGREEMENT);
    }

    @Override
    public void pay(Long orderId, String type) {
        this.sendEvent(StatusEvent.PAY);
    }

    private void sendEvent(StatusEvent event) {
        stateMachine.acquireStateMachine("one").sendEvent(MessageBuilder
                .withPayload(event)
                .setHeader("orderId", 110)
                .build());
    }

}
