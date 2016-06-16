package com.busi.interceptor.resolver;

import com.busi.interceptor.annotation.Loggable;
import org.springframework.stereotype.Service;

/**
 * Created by wanglei on 16/6/16.
 */
@Service
public class AnnotationResolverImpl implements AnnotationResolver {
    @Override
    public void doBefore(Loggable loggable) {
        System.out.println("Aop do before...");
    }

    @Override
    public void doAfter(Loggable loggable) {
        System.out.println("Aop do after...");
    }

    @Override
    public void doException(Loggable loggable, Throwable throwable) {
        System.out.println("Aop do exception:" + throwable.getMessage());
    }
}
