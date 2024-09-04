import java.util.List;

public class AverageClassAverageCalculator<S extends Student<?>> implements ClassAverageCalculator<S> {
    @Override
    public double calculateAverage(List<S> students) {
        double total = 0;
        int count = 0;
        for (S student : students) {
            total += student.getGrades().stream().mapToDouble(g -> ((Number) g).doubleValue()).sum();
            count += student.getGrades().size();
        }
        return count == 0 ? 0 : total / count;
    }
}