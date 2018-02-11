package com.busi.event;

import com.busi.domain.Users;
import com.busi.domain.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author WangLei
 * on 2018/2/9
 */
@Slf4j
@Component
public class EmailListener {

    @Autowired
    private UsersRepository usersRepository;

    @Async
    @TransactionalEventListener
    public void emallSendEvent(Users users) {
        log.info("Begin Email Event:" + users.toString());
        Users u = usersRepository.findByUsername("testEvent");
        String newUserName = u.getUsername() + users.getUsername();
        users.setUsername(newUserName);
        usersRepository.save(users);
    }
}
