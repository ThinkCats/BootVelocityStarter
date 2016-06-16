package com.app;

import com.busi.service.TestAopServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@Configuration
@EnableAutoConfiguration
@ComponentScan(value = "com.busi.**")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@ContextConfiguration("classpath*:spring.xml")
@WebAppConfiguration
public class DemoApplicationTests {

	@Autowired
	private TestAopServiceImpl testAopService;

	@Test
	public void contextLoads() {
		testAopService.testAop();
	}

}
