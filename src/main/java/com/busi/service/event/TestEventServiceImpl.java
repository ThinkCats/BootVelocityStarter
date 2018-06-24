package com.busi.service.event;

import com.busi.domain.Users;
import com.busi.domain.UsersRepository;
import com.busi.event.entity.TestEvent;
import com.busi.event.entity.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author WangLei
 * on 2018/2/9
 */
@Slf4j
@Service
public class TestEventServiceImpl implements TestEventService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void doSomethingBeforeSendEmail() {
        Users users = new Users();
        users.setEnabled(0);
        users.setPassword("testEvent");
        users.setUsername("testEvent");
        addUserInfo(users);

        UserEvent eventUser = new UserEvent();
        eventUser.setEnabled(0);
        eventUser.setUsername("EventName");
        eventUser.setPassword("EventPassword");
        log.info("=======> send event");
        applicationEventPublisher.publishEvent(eventUser);
        log.info("=======> send over");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("========> Main process over");

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doSomethingWithRollback() {
        Users users = new Users();
        users.setEnabled(0);
        users.setPassword("transPwd");
        users.setUsername("transUserName");
        addUserInfo(users);
        TestEvent event = new TestEvent();
        event.setName("tansEventName");
        event.setMsg("transEventMsg");
        applicationEventPublisher.publishEvent(event);
    }

    private void addUserInfo(Users users) {
        usersRepository.save(users);
    }
}
