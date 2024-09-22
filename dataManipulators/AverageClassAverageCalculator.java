package dataManipulators;

import java.util.List;
import dataModels.Student;

/**
 * \*\*Class\*\*
 * dataManipulators.AverageClassAverageCalculator
 * <p>
 * \*\*Description\*\*
 * This class implements the dataManipulators.ClassAverageCalculator interface to calculate the average class average for a list of students.
 * <p>
 * \*\*Type Parameters\*\*
 * \- \`<S>\` \- the type of student, which must extend the dataModels.Student class.
 */
public class AverageClassAverageCalculator<S extends Student<?>> implements ClassAverageCalculator<S> {

    /**
     * Calculates the average class average for a list of students.
     * <p>
     * \*\*Parameters\*\*
     * \- \`students\` \- a list of students for whom the average class average is to be calculated.
     * <p>
     * \*\*Returns\*\*
     * \- the average class average as a double. If there are no grades, returns 0.
     */
    @Override
    public double calculateAverage(List<S> students) {
        double total = 0;
        int count = 0;

        // Iterate over each student to sum up their grades and count the number of grades
        for (S student : students) {
            total += student.getGrades().stream().mapToDouble(g -> ((Number) g).doubleValue()).sum();
            count += student.getGrades().size();
        }

        // Calculate and return the average class average
        return count == 0 ? 0 : total / count;
    }
}