package reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class PassFailStrategyTest {

   @Test
   public void testApplyStrategy_Pass() {
      PassFailStrategy strategy = new PassFailStrategy();
      Mono<String> result = strategy.applyStrategy(75);

      StepVerifier.create(result)
            .expectNext("Pass")
            .verifyComplete();
   }

   @Test
   public void testApplyStrategy_Fail() {
      PassFailStrategy strategy = new PassFailStrategy();
      Mono<String> result = strategy.applyStrategy(50);

      StepVerifier.create(result)
            .expectNext("Fail")
            .verifyComplete();
   }

   @Test
   public void testApplyStrategy_BorderlinePass() {
      PassFailStrategy strategy = new PassFailStrategy();
      Mono<String> result = strategy.applyStrategy(60);

      StepVerifier.create(result)
            .expectNext("Pass")
            .verifyComplete();
   }

   @Test
   public void testApplyStrategy_BorderlineFail() {
      PassFailStrategy strategy = new PassFailStrategy();
      Mono<String> result = strategy.applyStrategy(59);

      StepVerifier.create(result)
            .expectNext("Fail")
            .verifyComplete();
   }
}