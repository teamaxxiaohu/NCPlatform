package com.gov.nc.interceptor;

import com.gov.nc.utils.MongoDBUtil;
import com.mongodb.BasicDBObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Created by Vincent_2 on 2014/12/28.
 * Test the AOP of spring
 */

@Aspect
public class AccountInterceptor {

    /* 定义切入点 */

    @Pointcut("execution(public * com.gov.nc.services..*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void doLogin(JoinPoint joinPoint){
        System.out.println("=====================================================");
        try{
            Signature signature = joinPoint.getSignature();

            BasicDBObject  basicDBObject = new BasicDBObject();
            basicDBObject.put("Class",joinPoint.getClass()+"");
            basicDBObject.put("Method",joinPoint.getClass()+ signature.getName());
            basicDBObject.put("Type",signature.getDeclaringType());
            basicDBObject.put("LongString",signature.toLongString());
            basicDBObject.put("Target",joinPoint.getTarget()+"");
            basicDBObject.put("Date", new Date());
            MongoDBUtil.getSysLogCollection().insert(basicDBObject);
            System.out.println(basicDBObject.get("Target"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @After("pointCut()")
    public void doRegister(JoinPoint joinPoint){
        System.out.println("==============ssssssssss=======================================");
        try{
            Signature signature = joinPoint.getSignature();
            BasicDBObject  basicDBObject = new BasicDBObject();
            basicDBObject.put("Class",joinPoint.getClass()+"");
            basicDBObject.put("Method",joinPoint.getClass()+ signature.getName());
            basicDBObject.put("Target",joinPoint.getTarget()+"");
            basicDBObject.put("Date", new Date());
            MongoDBUtil.getSysLogCollection().insert(basicDBObject);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
