package com.busi.interceptor.resolver;

import com.busi.interceptor.annotation.Loggable;

/**
 * Created by wanglei on 16/6/16.
 */
public interface AnnotationResolver {
    void doBefore(Loggable loggable, Object serialNo);

    void doAfter(Loggable loggable, Object serialNo);

    void doException(Loggable loggable, Object serialNo, Throwable throwable);
}
