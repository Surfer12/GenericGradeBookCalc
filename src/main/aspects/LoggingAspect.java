package main.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import javax.inject.Singleton;

/**
 * Aspect for logging method execution.
 */
@Aspect
@Singleton
public class LoggingAspect {

    @Before("execution(* dataModels.*.*(..))")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        System.out.println("Before executing: " + joinPoint.getSignature());
    }

    @After("execution(* dataModels.*.*(..))")
    public void afterMethodExecution(JoinPoint joinPoint) {
        System.out.println("After executing: " + joinPoint.getSignature());
    }
}