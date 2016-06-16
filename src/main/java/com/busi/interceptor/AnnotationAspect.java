package com.busi.interceptor;

import com.busi.interceptor.annotation.Loggable;
import com.busi.interceptor.annotation.SerialNumber;
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

    @Around("execution(@com.busi.interceptor.annotation.Loggable * *(@com.busi.interceptor.annotation.SerialNumber(*))) && args(number)")
    public Object doSome(ProceedingJoinPoint joinPoint,String number) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Loggable loggable = signature.getMethod().getAnnotation(Loggable.class);
        System.out.println("------------ annotation:"+ number);
//        SerialNumber serialNumber = signature.getMethod().getDeclaredAnnotation(SerialNumber.class);
//        System.out.println("------------ Before get your serial number:"+serialNumber.value());
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
