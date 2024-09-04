public interface GradeCalculator<S extends Student<?>> {
    double calculateAverage(S student);
}
