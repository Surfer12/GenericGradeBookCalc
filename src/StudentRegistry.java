import java.util.List;

/**
 * The StudentRegistry interface defines methods for adding a student to the registry and retrieving all students.
 *
 * @param <S> the type of Student
 */
public interface StudentRegistry<S extends Student<?>> {

    /**
     * Adds a student to the registry.
     *
     * @param student the student to be added
     */
    void addStudent(S student);

    /**
     * Retrieves all students from the registry.
     *
     * @return a list of all students
     */
    List<S> getAllStudents();
}