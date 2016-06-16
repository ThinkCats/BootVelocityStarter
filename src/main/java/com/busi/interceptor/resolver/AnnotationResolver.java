package com.busi.interceptor.resolver;

import com.busi.interceptor.annotation.Loggable;

/**
 * Created by wanglei on 16/6/16.
 */
public interface AnnotationResolver {
    void doBefore(Loggable loggable);
    void doAfter(Loggable loggable);
    void doException(Loggable loggable ,Throwable throwable);
}
