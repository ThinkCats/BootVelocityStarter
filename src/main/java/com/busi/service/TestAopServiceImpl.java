package com.busi.service;

import com.busi.framework.annotation.Loggable;
import org.springframework.stereotype.Service;

/**
 * Created by wanglei on 16/6/15.
 */

@Service
public class TestAopServiceImpl implements TestAopService {
    @Override
    @Loggable(desc = "hehehe")
    public void testAop() {
        System.out.println("this is test aop");
    }
}
