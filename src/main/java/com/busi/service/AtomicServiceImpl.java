package com.busi.service;

import com.busi.interceptor.annotation.Loggable;
import com.busi.interceptor.annotation.SerialNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by wanglei on 16/6/16.
 */
@Slf4j
@Service
public class AtomicServiceImpl implements AtomicService {

    @Override
    @Loggable(desc = "apiOne")
    public void doApiOne(@SerialNumber("zhima")String number,String other) {
        log.info("do api one");
    }

    @Override
    @Loggable(desc = "apiTwo")
    public void doApiTwo() {
        log.info("do api Exception");
    }
}
