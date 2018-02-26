package com.busi.event;

import com.busi.domain.Users;
import com.busi.domain.UsersRepository;
import com.busi.event.entity.TestEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author WangLei
 * on 2018/2/11
 */
@Slf4j
@Component
public class WithTransactionListener {

    @Resource
    private UsersRepository usersRepository;

    @EventListener
    @Transactional(rollbackFor = Exception.class)
    public void doWithTrans(TestEvent event) {
        log.info("Do With Trans Event:" + event.toString());
        Users u = usersRepository.findByUsername("transUserName");
        Users users = new Users();
        users.setUsername(u.getUsername() + event.getName());
        users.setPassword(event.getMsg());
        users.setEnabled(0);
        usersRepository.save(users);
    }
}
