package com.busi.event;

import com.busi.domain.Users;
import com.busi.domain.UsersRepository;
import com.busi.event.entity.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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

    private int count = 1;

    @Async
    @TransactionalEventListener
    @Transactional(rollbackFor = Exception.class)
    public void emallSendEvent(UserEvent event) {

        log.info("****** event begin");
        Users users = new Users();
        BeanUtils.copyProperties(event, users);
        log.info("******* Begin Email Event:" + users.toString());
        Users u = usersRepository.findByUsername("testEvent");
        String newUserName = u.getUsername() + users.getUsername() + count;
        users.setUsername(newUserName);
        usersRepository.save(users);
        count++;
        log.info("****** event over");
        System.out.println(1 / 0);
    }

}
