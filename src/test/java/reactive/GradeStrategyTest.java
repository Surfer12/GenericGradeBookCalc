// src/test/java/reactive/GradeStrategyTest.java
package reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class GradeStrategyTest {

    private final GradeStrategy gradeStrategy = new GradeStrategy() {
        @Override
        public Mono<String> calculateGrade(int grade) {
            if (grade >= 90) {
                return Mono.just("A");
            } else if (grade >= 80) {
                return Mono.just("B");
            } else if (grade >= 70) {
                return Mono.just("C");
            } else if (grade >= 60) {
                return Mono.just("D");
            } else {
                return Mono.just("F");
            }
        }
    };

    @Test
    public void testCalculateGrade_A() {
        StepVerifier.create(gradeStrategy.calculateGrade(95))
                .expectNext("A")
                .verifyComplete();
    }

    @Test
    public void testCalculateGrade_B() {
        StepVerifier.create(gradeStrategy.calculateGrade(85))
                .expectNext("B")
                .verifyComplete();
    }

    @Test
    public void testCalculateGrade_C() {
        StepVerifier.create(gradeStrategy.calculateGrade(75))
                .expectNext("C")
                .verifyComplete();
    }

    @Test
    public void testCalculateGrade_D() {
        StepVerifier.create(gradeStrategy.calculateGrade(65))
                .expectNext("D")
                .verifyComplete();
    }

    @Test
    public void testCalculateGrade_F() {
        StepVerifier.create(gradeStrategy.calculateGrade(55))
                .expectNext("F")
                .verifyComplete();
    }
}