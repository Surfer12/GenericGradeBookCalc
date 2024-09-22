package reactive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class GradeProcessingExample implements CommandLineRunner {

    private final StudentGradeProcessor letterProcessor;
    private final StudentGradeProcessor passFailProcessor;

    
    public GradeProcessingExample(GradeStrategy letterStrategy, GradeStrategy passFailStrategy) {
        this.letterProcessor = new StudentGradeProcessor(letterStrategy);
        this.passFailProcessor = new StudentGradeProcessor(passFailStrategy);
    }

    @Override
    public void run(String... args) {
        // Create a flux of student grades
        Flux<Integer> grades = Flux.just(95, 80, 65, 50, 75);

        System.out.println("Letter Grades:");
        letterProcessor.processGrades(grades)
                .subscribe(System.out::println);

        System.out.println("\nPass/Fail Results:");
        passFailProcessor.processGrades(grades)
                .subscribe(System.out::println);
    }
}