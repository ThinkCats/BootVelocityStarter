package com.busi.service.state;

import com.busi.domain.Orders;
import com.busi.domain.OrderRepository;
import com.busi.state.enums.StatusEnum;
import com.busi.state.enums.StatusEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * @author WangLei
 * on 2018/6/24
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private StateMachineFactory<StatusEnum,StatusEvent> stateMachineFactory;
    @Autowired
    private OrderRepository orderRepository;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void create() {
        Orders order = new Orders();
        order.setStatus(StatusEnum.INIT.name());
        order.setDateCreate(new Date());
        Orders orders = orderRepository.save(order);
        this.build(orders.getId()).sendEvent(MessageBuilder
                .withPayload(StatusEvent.CREATE)
                .setHeader("orderId", 10)
                .build()
        );
    }

    @Override
    public void signAgree(Long orderId, String type) {
        this.build(orderId).sendEvent(MessageBuilder
                .withPayload(StatusEvent.SIGN_AGREEMENT)
                .setHeader("orderId", 10)
                .build()
        );
    }

    @Override
    public void pay(Long orderId, String type) {
        this.build(orderId).sendEvent(MessageBuilder
                .withPayload(StatusEvent.PAY)
                .setHeader("orderId", 10)
                .setHeader("amount", 4000)
                .build()
        );
    }

    private StateMachine<StatusEnum, StatusEvent> build(Long orderId) {
        return stateMachineFactory.getStateMachine(orderId+"");
    }

//    private StateMachine<StatusEnum, StatusEvent> build(Long orderId) {
//        Orders order = orderRepository.findById(orderId).get();
//        String key = Long.toString(orderId);
//        StateMachine<StatusEnum, StatusEvent> stateMachine = this.stateMachineFactory.getStateMachine(key);
//        //停止可能存在的状态机
//        stateMachine.stop();
//        stateMachine.getStateMachineAccessor()
//                .doWithAllRegions(function -> {
//
////                    function.addStateMachineInterceptor(new StateMachineInterceptorAdapter<StatusEnum, StatusEvent>() {
////                        @Override
////                        public void preStateChange(State<StatusEnum, StatusEvent> state, Message<StatusEvent> message, Transition<StatusEnum, StatusEvent> transition, StateMachine<StatusEnum, StatusEvent> stateMachine) {
////                            Optional.ofNullable(message).ifPresent(msg ->
////                                    Optional.ofNullable(Long.class.cast(msg.getHeaders().getOrDefault("orderId", -1L)))
////                                            .ifPresent(orderId ->
////                                                    orderRepository.findById(orderId).ifPresent(order -> {
////                                                        order.setStatus(state.getId().name());
////                                                        orderRepository.save(order);
////                                                    })));
////                        }
////                    });
//
//                    StatusEnum statusEnum = StatusEnum.valueOf(order.getStatus());
//                    function.resetStateMachine(new DefaultStateMachineContext<>(
//                            statusEnum, null, null, null
//                    ));
//                });
//        stateMachine.start();
//        return stateMachine;
//    }

}
