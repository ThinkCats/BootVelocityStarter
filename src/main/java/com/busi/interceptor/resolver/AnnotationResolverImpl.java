package com.busi.interceptor.resolver;

import com.busi.interceptor.annotation.Loggable;
import org.springframework.stereotype.Service;

/**
 * Created by wanglei on 16/6/16.
 */
@Service
public class AnnotationResolverImpl implements AnnotationResolver {
    @Override
    public void doBefore(Loggable loggable ,Object serialNo) {
        System.out.println("Aop do before...");
        System.out.println("Get Serial:"+serialNo);
    }

    @Override
    public void doAfter(Loggable loggable,Object serialNo) {
        System.out.println("Aop do after...");
        System.out.println("Get Serial:"+serialNo);
    }

    @Override
    public void doException(Loggable loggable,Object serialNo ,Throwable throwable) {
        System.out.println("Aop do exception:" + throwable.getMessage());
    }
}
