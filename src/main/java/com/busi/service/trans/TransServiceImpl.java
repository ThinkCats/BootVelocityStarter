package com.busi.service.trans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class TransServiceImpl implements TransService {

    @Autowired
    private TransBusiService transBusiService;

    @Transactional
    @Override
    public void doSomethingWithTransaction() {

        // Transaction rolled back because it has been marked as rollback-only
        try {
            serviceWithException();
        } catch (Exception e) {
            log.info("catch error ...");
        }

//        try {
//            serviceWithException();
//        } catch (Exception e) {
//            log.info("catch error ...");
//        }
        log.info("do something over ");
    }

    private void serviceWithException() {
        transBusiService.callMethodWithException();
    }


}
