package com.busi.service.event;

import com.busi.domain.Users;
import com.busi.domain.UsersRepository;
import com.busi.event.entity.TestEvent;
import com.busi.event.entity.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author WangLei
 * on 2018/2/9
 */
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
        applicationEventPublisher.publishEvent(eventUser);
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
