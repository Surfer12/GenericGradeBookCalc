package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * **Class**
 * aspects.LoggingAspect
 * <p>
 * **Description**
 * Aspect for logging method calls.
 */
@Aspect
public class LoggingAspect {
    @Before("execution(* dataManipulators.*.*(..))")
    public void logBefore() {
        System.out.println("Method called in dataManipulators package");
    }
}
