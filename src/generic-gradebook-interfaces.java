public interface StudentRegistry<S extends Student> {
    void addStudent(S student);
    List<S> getAllStudents();
}

public interface GradeEntrySystem<S extends Student, G> {
    void enterGradesForStudent(S student);
}

public interface GradebookDisplay<S extends Student> {
    void displayGradebook(List<S> students);
}

public interface ClassAverageCalculator<S extends Student> {
    double calculateClassAverage(List<S> students);
}

public interface GradeCalculator<S extends Student> {
    double calculateAverage(S student);
}
