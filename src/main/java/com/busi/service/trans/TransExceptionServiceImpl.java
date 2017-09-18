package com.busi.service.trans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TransExceptionServiceImpl implements TransExceptionService {

    @Transactional
    @Override
    public void methodWithException() {
        log.info("method with exception in transaction ...");
        throw new RuntimeException("query error ...");
    }
}
