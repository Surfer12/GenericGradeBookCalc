package reactive;

import reactor.core.publisher.Mono;

public interface GradeStrategy {
    Mono<String> applyStrategy(Integer grade);

    Object calculateGrade(int i);
}