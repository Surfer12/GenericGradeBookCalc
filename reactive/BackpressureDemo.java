package src.main.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class BackpressureDemo {
   public static void main(String[] args) {
      Flux<Integer> grades = Flux.range(1, 100)
            .onBackpressureBuffer()
            .publishOn(Schedulers.boundedElastic());

      grades.subscribe(
            grade -> System.out.println("Processing grade: " + grade),
            error -> System.err.println("Error: " + error),
            () -> System.out.println("Processing complete"));
   }
}