package com.app.service;

import com.busi.service.threadlocal.ThreadLocalService;
import com.busi.service.threadlocal.ThreadLocalServiceImpl;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Test;

/**
 * @author WangLei
 * on 2019/6/28
 */
public class ThreadLocalTest {

    @Test
    public void testThreadLocalParam() throws InterruptedException {
        ThreadLocalService service = new ThreadLocalServiceImpl();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            String name = "TestUserName" + finalI;
            String productId = finalI + "";
            String orderNo = "OrderNo" + finalI;
            new Thread(() -> service.doSomething(name, productId, orderNo)).start();
        }
        new Thread(() -> {
        }).join(2000);
    }

    @Test
    public void testThreadLocalWithExecutors() {
        ThreadLocalService service = new ThreadLocalServiceImpl();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> runBiz(service, 1));
        executorService.execute(() -> runBiz(service, 2));
        executorService.execute(() -> runBiz(service, 1));
        executorService.execute(() -> runBiz(service, 2));
        executorService.execute(() -> runBiz(service, 5));
        executorService.shutdown();
    }

    private void runBiz(ThreadLocalService service, int finalI) {
        String name = "TestUserName" + finalI;
        String productId = finalI + "";
        String orderNo = "OrderNo" + finalI;
        service.doSomething(name, productId, orderNo);
    }
}
