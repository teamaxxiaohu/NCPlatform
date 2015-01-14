package com.gov.nc.interceptor;

import com.gov.nc.bean.Account;
import com.gov.nc.utils.MongoDBUtil;
import com.mongodb.BasicDBObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Created by Vincent_2 on 2014/12/28.
 * Test the AOP of spring
 */

@Aspect
@Component
public class LogInterceptor {


    /* 定义切入点 */

    @Pointcut("execution(* com.gov.nc.services..*(..))")
    public void pointCut(){}

    @After("pointCut()")
    public void doLogin(JoinPoint joinPoint){

        try{

            Object object[] = joinPoint.getArgs();

            BasicDBObject  basicDBObject = new BasicDBObject();
            /* set visit information */
            basicDBObject.put("Class",joinPoint.getSignature().getClass()+ "");
            basicDBObject.put("Service Name",joinPoint.getSignature().getDeclaringType()+"");
            basicDBObject.put("Execute Method",joinPoint.getSignature().getName()+"");
            basicDBObject.put("Kind",joinPoint.getKind()+"");
            basicDBObject.put("Time",new Date());

            /* get visit parameters */
            for(int i = 0 ; i < object.length; i++){
                basicDBObject.put("param"+i, object[i].toString());
            }

            MongoDBUtil.getSysLogCollection().insert(basicDBObject);
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}
