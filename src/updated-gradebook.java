public class GradeBook<S extends Student> {
    private final StudentRegistry<S> studentRegistry;
    private final InputHandler<String> nameInputHandler;
    private final InputHandler<Integer> countInputHandler;
    private final GradeEntrySystem<S, Integer> gradeEntrySystem;
    private final GradeCalculator<S> gradeCalculator;
    private final GradebookDisplay<S> gradebookDisplay;
    private final ClassAverageCalculator<S> classAverageCalculator;
    private final Supplier<S> studentFactory;

    public GradeBook(
            StudentRegistry<S> studentRegistry,
            InputHandler<String> nameInputHandler,
            InputHandler<Integer> countInputHandler,
            GradeEntrySystem<S, Integer> gradeEntrySystem,
            GradeCalculator<S> gradeCalculator,
            GradebookDisplay<S> gradebookDisplay,
            ClassAverageCalculator<S> classAverageCalculator,
            Supplier<S> studentFactory) {
        this.studentRegistry = studentRegistry;
        this.nameInputHandler = nameInputHandler;
        this.countInputHandler = countInputHandler;
        this.gradeEntrySystem = gradeEntrySystem;
        this.gradeCalculator = gradeCalculator;
        this.gradebookDisplay = gradebookDisplay;
        this.classAverageCalculator = classAverageCalculator;
        this.studentFactory = studentFactory;
    }

    public void run() {
        enterStudentNames();
        enterStudentGrades();
        calculateAverages();
        displayResults();
    }

    private void enterStudentNames() {
        int numStudents = countInputHandler.getInput("Enter the number of students: ");
        for (int i = 0; i < numStudents; i++) {
            String name = nameInputHandler.getInput("Enter the name of student " + (i + 1) + ": ");
            S student = studentFactory.get();
            student.setName(name);
            studentRegistry.addStudent(student);
        }
    }

    private void enterStudentGrades() {
        for (S student : studentRegistry.getAllStudents()) {
            gradeEntrySystem.enterGradesForStudent(student);
        }
    }

    private void calculateAverages() {
        for (S student : studentRegistry.getAllStudents()) {
            double average = gradeCalculator.calculateAverage(student);
            student.setAverage(average);
        }
    }

    private void displayResults() {
        gradebookDisplay.displayGradebook(studentRegistry.getAllStudents());
        double classAverage = classAverageCalculator.calculateClassAverage(studentRegistry.getAllStudents());
        System.out.printf("Class Average: %.2f%n", classAverage);
    }
}
