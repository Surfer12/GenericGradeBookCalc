package main.java.reactive;

import reactor.core.publisher.Mono;

public interface GradeStrategy {
    Mono<String> applyStrategy(Integer grade);
}