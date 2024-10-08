package reactive;

import reactor.core.publisher.Flux;


public class StudentGradeProcessor {
    private final GradeStrategy strategy;

    public StudentGradeProcessor(GradeStrategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        GradeStrategy strategy = new PassFailStrategy();
        StudentGradeProcessor processor = new StudentGradeProcessor(strategy);

        Flux<Integer> grades = Flux.just(85, 70, 55, 90, 40);
        processor.processGrades(grades)
                .subscribe(System.out::println);
    }

    public Flux<String> processGrades(Flux<Integer> grades) {
        return grades.flatMap(strategy::applyStrategy);
    }
}