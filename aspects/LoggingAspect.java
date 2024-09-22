package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

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
    
    @After("execution(* dataManipulators.*.*(..))") // Changed @Before to @After
    public void logAfter() {
        System.out.println("Method finished in dataManipulators package"); // New logging for method completion
    }
}
