package reactive;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;



public class GradeStrategyTest {

   private final GradeStrategy gradeStrategy=new GradeStrategy(){@Override public Mono<String>applyStrategy(Integer grade){if(grade>=90){return Mono.just("A");}else if(grade>=80){return Mono.just("B");}else if(grade>=70){return Mono.just("C");}else if(grade>=60){return Mono.just("D");}else{return Mono.just("F");}}};

   @Test
   public void testApplyStrategy_A() {
      StepVerifier.create(gradeStrategy.applyStrategy(95))
            .expectNext("A")
            .verifyComplete();
   }

   @Test
   public void testApplyStrategy_B() {
      StepVerifier.create(gradeStrategy.applyStrategy(85))
            .expectNext("B")
            .verifyComplete();
   }

   @Test
   public void testApplyStrategy_C() {
      StepVerifier.create(gradeStrategy.applyStrategy(75))
            .expectNext("C")
            .verifyComplete();
   }

   @Test
   public void testApplyStrategy_D() {
      StepVerifier.create(gradeStrategy.applyStrategy(65))
            .expectNext("D")
            .verifyComplete();
   }

   @Test
   public void testApplyStrategy_F() {
      StepVerifier.create(gradeStrategy.applyStrategy(55))
            .expectNext("F")
            .verifyComplete();
   }
}