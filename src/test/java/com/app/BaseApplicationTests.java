package com.app;

import com.busi.service.trans.TransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseApplicationTests {

    @Autowired
    private TransService transService;

    @Test
    public void test() {
        transService.doSomethingWithTransaction();
    }

}
