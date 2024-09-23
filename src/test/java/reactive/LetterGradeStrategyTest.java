package reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


public class LetterGradeStrategyTest {

    private final LetterGradeStrategy letterGradeStrategy = new LetterGradeStrategy();

    @Test
    public void testApplyStrategy_A() {
        Mono<String> result = letterGradeStrategy.applyStrategy(95);
        StepVerifier.create(result)
                .expectNext("A")
                .verifyComplete();
    }

    @Test
    public void testApplyStrategy_B() {
        Mono<String> result = letterGradeStrategy.applyStrategy(85);
        StepVerifier.create(result)
                .expectNext("B")
                .verifyComplete();
    }

    @Test
    public void testApplyStrategy_C() {
        Mono<String> result = letterGradeStrategy.applyStrategy(75);
        StepVerifier.create(result)
                .expectNext("C")
                .verifyComplete();
    }

    @Test
    public void testApplyStrategy_D() {
        Mono<String> result = letterGradeStrategy.applyStrategy(65);
        StepVerifier.create(result)
                .expectNext("D")
                .verifyComplete();
    }

    @Test
    public void testApplyStrategy_F() {
        Mono<String> result = letterGradeStrategy.applyStrategy(55);
        StepVerifier.create(result)
                .expectNext("F")
                .verifyComplete();
    }
}