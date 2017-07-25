package com.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(value = "com.busi.**")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BaseApplicationTests {

    @Test
    public void test() {
    }

}
