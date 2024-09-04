import java.util.List;

public interface ClassAverageCalculator<S extends Student<?>> {
    double calculateAverage(List<S> students);
}