import reactor.core.publisher.Flux;
import reactive.GradeStrategy;
import reactive.LetterGradeStrategy;
import reactive.PassFailStrategy;
import reactive.StudentGradeProcessor;

public class Application {
    public static void main(String[] args) {
        // Create a flux of student grades
        Flux<Integer> grades = Flux.just(95, 80, 65, 50, 75);

        // Process grades using LetterGradeStrategy
        GradeStrategy letterStrategy = new LetterGradeStrategy();
        StudentGradeProcessor letterProcessor = new StudentGradeProcessor(letterStrategy);
        
        System.out.println("Letter Grades:");
        letterProcessor.processGrades(grades)
            .subscribe(System.out::println);

        // Process grades using PassFailStrategy
        GradeStrategy passFailStrategy = new PassFailStrategy();
        StudentGradeProcessor passFailProcessor = new StudentGradeProcessor(passFailStrategy);
        
        System.out.println("\nPass/Fail Results:");
        passFailProcessor.processGrades(grades)
            .subscribe(System.out::println);
    }
}

