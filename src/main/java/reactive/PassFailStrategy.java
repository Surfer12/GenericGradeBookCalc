package reactive;

import reactor.core.publisher.Mono;

public class PassFailStrategy implements GradeStrategy {
    @Override
    public Mono<String> applyStrategy(Integer grade) {
        return Mono.just(grade >= 60 ? "Pass" : "Fail");
    }
@Override
public Mono<String> calculateGrade(int i) {
    return Mono.just(i >= 60 ? "Pass" : "Fail");
}

    static PassFailStrategy getInstance() {
        return new PassFailStrategy();
    }
}