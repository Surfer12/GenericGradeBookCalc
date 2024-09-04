import java.util.List;

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
