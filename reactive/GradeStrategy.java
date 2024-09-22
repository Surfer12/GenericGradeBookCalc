package reactive;
public interface GradeStrategy {
   Mono<String> applyStrategy(Integer grade);
}