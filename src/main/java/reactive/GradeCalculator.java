package main.java.reactive;

import reactor.core.publisher.Flux;
import main.java.reactive.GradeStrategy;
import main.java.reactive.LetterGradeStrategy;
import main.java.reactive.PassFailStrategy;

public class GradeCalculator {
    public static void main(String[] args) {
        GradeStrategy strategy = new LetterGradeStrategy();

        Flux<Integer> grades = Flux.just(95, 82, 67, 54, 88);

        grades.flatMap(strategy::applyStrategy)
                .subscribe(letterGrade -> System.out.println("Letter Grade: " + letterGrade));
    }
}