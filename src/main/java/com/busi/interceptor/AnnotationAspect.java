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

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;

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

        Object serialNum = null;

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        //获取到自定义的方法注解
        Loggable loggable = method.getAnnotation(Loggable.class);

        //获取到该方法的所有参数
        Object[] args = joinPoint.getArgs();

        //获取到该方法里面的所有注解
        Annotation[][] annotations = method.getParameterAnnotations();
        //遍历每个参数上面的注解,可能有多个
        for (int i = 0; i < annotations.length; i++) {
            Annotation[] paramAnnotions = annotations[i];
            for (Annotation annotation : paramAnnotions) {
                //处理自定义的流水号信息
                if (SerialNumber.class.isInstance(annotation)) {
                    serialNum = args[i];
                } else {
                    //处理其他类型的注解信息
                }
            }
        }

        System.out.println("serial number: " + serialNum);

        resolver.doBefore(loggable, serialNum);
        Object result = joinPoint.proceed();
        resolver.doAfter(loggable, serialNum);
        return result;
    }

    @AfterThrowing(value = "@annotation(com.busi.interceptor.annotation.Loggable)", throwing = "error")
    public void doException(JoinPoint joinPoint, Throwable error) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Loggable loggable = signature.getMethod().getAnnotation(Loggable.class);
        resolver.doException(loggable,"", error);
    }
}
