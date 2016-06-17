package com.busi.service;

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
        atomicService.doApiOne("9999999","干扰信息");
        atomicService.doApiTwo();
    }

}
