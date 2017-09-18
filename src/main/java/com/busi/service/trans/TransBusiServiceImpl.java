package com.busi.service.trans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TransBusiServiceImpl implements TransBusiService {

    @Autowired
    private TransExceptionService transExceptionService;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public void callMethodWithException() {
        try {
            transExceptionService.methodWithException();
        } catch (Exception e) {
            log.info("catch exception error");
        }
    }
}
