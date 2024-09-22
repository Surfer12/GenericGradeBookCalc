package reactive; 

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BackpressureDemo {
   public static void main(String[] args) {
      Flux<Integer> flux = Flux.range(1, 100)
            .publishOn(Schedulers.parallel())
            .doOnNext(data -> {
               // Simulate processing time
               try {
                  Thread.sleep(100); // Simulate a slow consumer
               } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
               }
               System.out.println("Processed: " + data);
            });

      flux.subscribe(
            item -> System.out.println("Received: " + item),
            error -> System.err.println("Error: " + error),
            () -> System.out.println("Completed")
      );

      // Keep the application running to observe the output
      try {
         Thread.sleep(10000); // Adjust time as needed
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
      }
   }
}