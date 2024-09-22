package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired; // Add this import

/**
 * **Class**
 * aspects.LoggingAspect
 * <p>
 * **Description**
 * Aspect for logging method calls.
 */
@Aspect
public class LoggingAspect {
    @Autowired // Inject the logger
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class); // Adjust logger initialization

    @Before("execution(* com.yourpackage..*(..))") // Adjust the pointcut expression as needed
    public void logBefore() {
        logger.info("Method execution started");
    }

    @After("execution(* com.yourpackage..*(..))") // Adjust the pointcut expression as needed
    public void logAfter() {
        logger.info("Method execution finished");
    }
}
