// src/main/java/reactive/GradeStrategy.java
package reactive;

import reactor.core.publisher.Mono;

public interface GradeStrategy {
    Mono<String> calculateGrade(int grade);

    Mono<String> applyStrategy(Integer grade);
}