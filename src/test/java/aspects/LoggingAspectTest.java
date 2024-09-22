package aspects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import static org.mockito.Mockito.verify;

public class LoggingAspectTest {

    private LoggingAspect loggingAspect;
    private Logger logger;

    @BeforeEach
    public void setUp() {
        logger = Mockito.mock(Logger.class);
        loggingAspect = new LoggingAspect() {
            @Override
            public Logger getLogger() {
                return logger;
            }
        };
    }

    @Test
    public void testLogBefore() {
        AspectJProxyFactory factory = new AspectJProxyFactory(new TestService());
        factory.addAspect(loggingAspect);
        TestService proxy = factory.getProxy();

        proxy.testMethod();

        verify(logger).info("Method execution started");
    }

    @Test
    public void testLogAfter() {
        AspectJProxyFactory factory = new AspectJProxyFactory(new TestService());
        factory.addAspect(loggingAspect);
        TestService proxy = factory.getProxy();

        proxy.testMethod();

        verify(logger).info("Method execution finished");
    }

    static class TestService {
        public void testMethod() {
            // Method to trigger aspect
        }
    }
}