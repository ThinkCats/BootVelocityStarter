package com.app.service;

import com.app.BaseApplicationTests;
import com.busi.service.trans.TransService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TrasactionTest extends BaseApplicationTests {

    @Autowired
    private TransService transService;

    @Test
    public void testTrans(){
        transService.doSomethingWithTransaction();
    }
}
