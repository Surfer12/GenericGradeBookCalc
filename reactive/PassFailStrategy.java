package src.main.reactive;

import reactor.core.publisher.Mono;

public class PassFailStrategy implements GradeStrategy {
   @Override
   public Mono<String> applyStrategy(Integer grade) {
      return Mono.just(grade >= 60 ? "Pass" : "Fail");
   }
}