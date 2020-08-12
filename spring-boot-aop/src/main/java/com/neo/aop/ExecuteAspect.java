package com.neo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author 樊斌
 * @Date 2020/8/12
 * @Version V1.0
 **/
@Aspect
@Slf4j(topic = "aopLogger")
public class ExecuteAspect {

    private long start_time;
    private long end_time;

    @Pointcut("execution(public * com.neo.controller.UserInfoCrudRepositoryController.*(..))")
    public void poinCut(){

    }

    @Before("poinCut()")
    public void beforeMethod(JoinPoint joinPoint){
        start_time = System.currentTimeMillis();
    }

    @After("poinCut()")
    public void afterMethod(JoinPoint joinPoint){
        end_time = System.currentTimeMillis();
    }

    @AfterReturning(value = "poinCut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        log.info("方法{}入参{}返回值{}执行时间{}",joinPoint.getSignature().getName(),Arrays.toString(joinPoint.getArgs()),result,(end_time-start_time));
    }

    @AfterThrowing(value = "poinCut()",throwing = "e")
    public void afterReturning(JoinPoint joinPoint,Exception e){
        log.error("方法{}入参{}执行时间{}异常{}",joinPoint.getSignature().getName(),Arrays.toString(joinPoint.getArgs()),(end_time-start_time),e.getMessage());
    }
}
