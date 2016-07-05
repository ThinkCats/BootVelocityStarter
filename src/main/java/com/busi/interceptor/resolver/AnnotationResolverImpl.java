package com.busi.interceptor.resolver;

import com.busi.interceptor.annotation.Loggable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by wanglei on 16/6/16.
 */
@Slf4j
@Service
public class AnnotationResolverImpl implements AnnotationResolver {
    @Override
    public void doBefore(Loggable loggable ,Object serialNo) {
        log.info("Aop do before...");
        log.info("Get Serial:"+serialNo);
    }

    @Override
    public void doAfter(Loggable loggable,Object serialNo) {
        log.info("Aop do after...");
        log.info("Get Serial:"+serialNo);
    }

    @Override
    public void doException(Loggable loggable,Object serialNo ,Throwable throwable) {
        log.info("Aop do exception:" + throwable.getMessage());
    }
}
