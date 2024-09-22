package reactive;

import reactor.core.publisher.Flux;

public class GradeCalculator {
    public static void main(String[] args) {
        GradeStrategy strategy = new LetterGradeStrategy();

        Flux<Integer> grades = Flux.just(95, 82, 67, 54, 88);

        grades.flatMap(strategy::applyStrategy)
                .subscribe(letterGrade -> System.out.println("Letter Grade: " + letterGrade));
    }
}