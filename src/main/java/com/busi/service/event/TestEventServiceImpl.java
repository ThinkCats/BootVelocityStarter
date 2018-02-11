package com.busi.service.event;

import com.busi.domain.Users;
import com.busi.domain.UsersRepository;
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

        Users eventUser = new Users();
        eventUser.setEnabled(0);
        eventUser.setUsername("EventName");
        eventUser.setPassword("EventPassword");
        applicationEventPublisher.publishEvent(eventUser);
    }

    private void addUserInfo(Users users) {
        usersRepository.save(users);
    }
}
