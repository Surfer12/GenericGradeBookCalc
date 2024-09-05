import java.util.List;
public class ClassAvgTotalCalc<S extends Student<G>, G extends Number> {
    public double calculateClassAverage(List<S> students) {
        double totalSum = 0;
        int totalGrades = 0;

        for (S student : students) {
            List<G> grades = student.getGrades();
            for (G grade : grades) {
                totalSum += grade.doubleValue();
                totalGrades++;
            }
        }

        return totalGrades == 0 ? 0 : totalSum / totalGrades;
    }
}