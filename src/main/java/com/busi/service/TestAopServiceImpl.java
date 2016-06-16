package com.busi.service;

import com.busi.framework.annotation.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanglei on 16/6/15.
 */

@Service
public class TestAopServiceImpl implements TestAopService {
    @Autowired
    private AtomicService atomicService;

    @Override
    public void testAop() {
        todo();
    }

    @Override
    public void todo() {
        System.out.println("this is todo service");
        atomicService.doApiOne();
        atomicService.doApiTwo();
    }

}
