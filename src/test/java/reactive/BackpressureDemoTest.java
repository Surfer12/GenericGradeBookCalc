package reactive;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;


public class BackpressureDemoTest {

   @Test
   public void testFluxProcessing() {
      Flux<Integer> flux = Flux.range(1, 100)
            .publishOn(Schedulers.parallel())
            .doOnNext(data -> {
               // Simulate processing time
               try {
                  Thread.sleep(100); // Simulate a slow consumer
               } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
               }
            });

      StepVerifier.create(flux)
            .expectNextCount(100)
            .verifyComplete();
   }

   @Test
   public void testFluxBackpressure() {
      Flux<Integer> flux = Flux.range(1, 100)
            .publishOn(Schedulers.parallel())
            .doOnNext(data -> {
               // Simulate processing time
               try {
                  Thread.sleep(100); // Simulate a slow consumer
               } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
               }
            });

      StepVerifier.create(flux.onBackpressureBuffer())
            .expectNextCount(100)
            .verifyComplete();
   }
}