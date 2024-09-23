package reactive;

import reactor.core.publisher.Mono;

public class PassFailStrategy implements GradeStrategy {
    @Override
    public Mono<String> applyStrategy(Integer grade) {
        return Mono.just(grade >= 60 ? "Pass" : "Fail");
    }

    @Override
    public Object calculateGrade(int i) {
        return i >= 60 ? "Pass" : "Fail";
    }

    static PassFailStrategy getInstance() {
        return new PassFailStrategy();
    }
}