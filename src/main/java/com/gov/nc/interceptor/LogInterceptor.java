package com.gov.nc.interceptor;

import com.gov.nc.utils.MongoDBUtil;
import com.mongodb.BasicDBObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * Created by Vincent_2 on 2014/12/28.
 * Test the AOP of spring
 */

@Aspect
@Component
public class LogInterceptor {


    /* 定义切入点 */

    @Pointcut("execution(* com.gov.nc.service..*(..))")
    public void pointCut(){}

    @After("pointCut()")
    public void doLogin(JoinPoint joinPoint){
        String declaringType = joinPoint.getSignature().getDeclaringTypeName();
    try{
        BasicDBObject  basicDBObject = new BasicDBObject();
        basicDBObject.put("Type", joinPoint.getSourceLocation()+"");
        basicDBObject.put("Class",joinPoint.getArgs()+"");
        basicDBObject.put("MethodName", joinPoint.getSignature().getName());
        MongoDBUtil.getSysLogCollection().insert(basicDBObject);
    }catch (Exception e){
        e.printStackTrace();
    }
        System.out.println(declaringType);
    }




}
