package main.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect for logging method execution.
 */
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* dataModels.StudentService.*(..))")
    public void logBeforeMethods(JoinPoint joinPoint) {
        System.out.println("Executing: " + joinPoint.getSignature().getName());
    }

    @After("execution(* dataModels.StudentService.*(..))")
    public void logAfterMethods(JoinPoint joinPoint) {
        System.out.println("Completed: " + joinPoint.getSignature().getName());
    }
}