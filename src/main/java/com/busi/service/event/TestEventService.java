package com.busi.service.event;

/**
 * @author WangLei
 * on 2018/2/9
 */
public interface TestEventService {

    void doSomethingBeforeSendEmail();

    void doSomethingWithRollback();

}
