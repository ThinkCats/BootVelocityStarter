package com.busi.framework;

import com.busi.framework.annotation.Loggable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Created by wanglei on 16/6/15.
 */
@Aspect
@Component
public class EmployeeAnnotationAspect {

    @Around("@annotation(com.busi.framework.annotation.Loggable)")
    public Object doSome(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Loggable loggable = signature.getMethod().getAnnotation(Loggable.class);
        System.out.println("--------- before desc:"+loggable.desc());
        Object result =  joinPoint.proceed();
        System.out.println("---------- after desc:"+loggable.desc());
        return result;
    }
}
