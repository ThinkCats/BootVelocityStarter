package com.busi.interceptor;

import com.busi.interceptor.annotation.Loggable;
import com.busi.interceptor.resolver.AnnotationResolver;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wanglei on 16/6/15.
 */
@Aspect
@Component
public class AnnotationAspect {
    @Autowired
    private AnnotationResolver resolver;

    @Around("@annotation(com.busi.interceptor.annotation.Loggable)")
    public Object doSome(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Loggable loggable = signature.getMethod().getAnnotation(Loggable.class);
        resolver.doBefore(loggable);
        Object result =  joinPoint.proceed();
        resolver.doAfter(loggable);
        return result;
    }

    @AfterThrowing(value = "@annotation(com.busi.interceptor.annotation.Loggable)", throwing = "error")
    public void doException(JoinPoint joinPoint, Throwable error){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Loggable loggable = signature.getMethod().getAnnotation(Loggable.class);
        resolver.doException(loggable,error);
    }
}
