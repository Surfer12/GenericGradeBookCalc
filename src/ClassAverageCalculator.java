import java.util.List;

public interface ClassAverageCalculator<S extends Student> {
    double calculateClassAverage(List<S> students);
}
