package aspects;

import org.aspectj.lang.annotation.Aspect; // Import Aspect
import org.aspectj.lang.annotation.After; // Import After
import org.aspectj.lang.annotation.Before; // Import Before
import org.slf4j.Logger; // Import Logger
import org.slf4j.LoggerFactory; // Import LoggerFactory
import org.springframework.stereotype.Component; // Import Component

/**
 * **Class**
 * aspects.LoggingAspect
 * <p>
 * **Description**
 * Aspect for logging method calls.
 */
@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* GenericGradeBookCalc..*(..))")
    public void logBefore() {
        logger.info("Method execution started");
    }

    @After("execution(* GenericGradeBookCalc..*(..))")
    public void logAfter() {
        logger.info("Method execution finished");
    }
}
