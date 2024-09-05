import java.util.function.Supplier;

public class DoubleGradeBook extends GradeBook<Student<Double>, Double> {
    public DoubleGradeBook(StudentRegistry<Student<Double>, Double> studentRegistry,
                           InputHandler<String> nameInputHandler,
                           InputHandler<Integer> countInputHandler,
                           GradeEntrySystem<Student<Double>, Double> gradeEntrySystem,
                           GradeCalculator<Student<Double>> gradeCalculator,
                           GradebookDisplay<Student<Double>> gradebookDisplay,
                           ClassAverageCalculator<Student<Double>> classAverageCalculator,
                           Supplier<Student<Double>> studentFactory) {
        super(studentRegistry, nameInputHandler, countInputHandler, gradeEntrySystem, gradeCalculator, gradebookDisplay, classAverageCalculator, studentFactory);
    }
}