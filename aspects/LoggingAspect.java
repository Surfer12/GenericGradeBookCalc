package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * **Class**
 * aspects.LoggingAspect
 * <p>
 * **Description**
 * Aspect for logging method calls.
 */
@Aspect
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.yourpackage..*(..))") // Adjust the pointcut expression as needed
    public void logBefore() {
        logger.info("Method execution started");
    }

    @After("execution(* com.yourpackage..*(..))") // Adjust the pointcut expression as needed
    public void logAfter() {
        logger.info("Method execution finished");
    }
}
