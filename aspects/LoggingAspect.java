package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
        logger.info("Method execution started");./gradlew build --refresh-dependencies
    }

    @After("execution(* GenericGradeBookCalc..*(..))")
    public void logAfter() {
        logger.info("Method execution finished");
    }
}
