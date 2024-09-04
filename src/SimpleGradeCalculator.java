public class SimpleGradeCalculator<S extends Student<?>> implements GradeCalculator<S> {
    @Override
    public double calculateAverage(S student) {
        if (student.getNumAssignments() == 0) {
            return 0;
        }
        return (double) student.getTotalScore() / student.getNumAssignments();
    }
}
