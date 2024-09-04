/**
 * An interface for entering grades for assignments in a grade entry system.
 *
 * @param <S> the type of student, which extends the Student class with a generic grade type
 * @param <G> the type of grade to be entered
 */
public interface GradeEntrySystem<S extends Student<G>, G> {

    /**
     * Enters a grade for a specific assignment for the given student.
     *
     * @param student          the student for whom the grade is to be entered
     * @param assignmentNumber the number of the assignment for which the grade is to be entered
     * @return the entered grade of type G
     */
    G enterGradeForAssignment(S student, int assignmentNumber);
}