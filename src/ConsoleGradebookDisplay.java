public class ConsoleGradebookDisplay<S extends Student> implements GradebookDisplay<S> {
    private static final String HEADER = "| Student  | Grades               | Avg  |";
    private static final String SEPARATOR = "-----------------------------------------";
    private static final String STUDENT_FORMAT = "| %-7s | %-20s | %.1f |";

    @Override
    public void displayGradebook(List<S> students) {
        System.out.println(SEPARATOR);
        System.out.println(HEADER);
        System.out.println(SEPARATOR);

        for (S student : students) {
            System.out.printf(STUDENT_FORMAT, student.getName(), student.getGradesAsString(), student.getAverage());
            System.out.println();
        }

        System.out.println(SEPARATOR);
    }
}
