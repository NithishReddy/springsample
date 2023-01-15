package com.example.springrocking.aop;

import java.time.LocalDateTime;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//this file is used for creating common log file for at every method level
@Aspect
@Component
public class LoggerAOP {


    private Logger logger = LoggerFactory.getLogger(getClass());

    //@Around("execution(* com.example.springrocking.service.*.*(..))")
    public void addLoginMethod(ProceedingJoinPoint pJoinPoint) throws Throwable{
        long start_time = System.currentTimeMillis();

        logger.info("Execution has started in class:{}, function: {} , at time: {}", pJoinPoint.getTarget().getClass(), pJoinPoint.getSignature().toString(), LocalDateTime.now());

        try{
            pJoinPoint.proceed();
        }
        catch(Exception e){
            System.out.print("Exception has occured in AOP");
        }
        

        long end_time = System.currentTimeMillis() - start_time;

        logger.info("Execution has ended in function:{} , at time: {}, time_took:{}", getClass(), LocalDateTime.now(), end_time);
    }
    
}
