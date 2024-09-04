public class SimpleStudentRegistry<S extends Student> implements StudentRegistry<S> {
    private final List<S> students = new ArrayList<>();

    @Override
    public void addStudent(S student) {
        students.add(student);
    }

    @Override
    public List<S> getAllStudents() {
        return new ArrayList<>(students);
    }
}

public class ConsoleGradeEntrySystem<S extends Student> implements GradeEntrySystem<S, Integer> {
    private final InputHandler<Integer> scoreInputHandler;

    public ConsoleGradeEntrySystem(InputHandler<Integer> scoreInputHandler) {
        this.scoreInputHandler = scoreInputHandler;
    }

    @Override
    public void enterGradesForStudent(S student) {
        System.out.println("Entering grades for " + student.getName() + ":");
        List<Integer> grades = scoreInputHandler.getMultipleInputs(
            "Enter grade (or type 'STOP' to finish): ",
            "STOP"
        );
        
        for (Integer grade : grades) {
            student.addGrade(grade);
        }
    }
}

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

public class AverageClassAverageCalculator<S extends Student> implements ClassAverageCalculator<S> {
    @Override
    public double calculateClassAverage(List<S> students) {
        if (students.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (S student : students) {
            total += student.getAverage();
        }
        return total / students.size();
    }
}

public class SimpleGradeCalculator<S extends Student> implements GradeCalculator<S> {
    @Override
    public double calculateAverage(S student) {
        if (student.getNumAssignments() == 0) {
            return 0;
        }
        return (double) student.getTotalScore() / student.getNumAssignments();
    }
}
