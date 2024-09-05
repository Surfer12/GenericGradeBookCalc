import java.util.List;
import java.util.Optional;

/**
 * The StudentRegistry interface defines methods for adding a student to the registry and
 * retrieving all students as well as removing a student and grabbing a student object by name .
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

 /**
     * Removes a student from the registry by their name.
     *
     * @param name the name of the student to be removed
     * @return an Optional containing the removed student if found, otherwise an empty Optional
     */
    Optional<S> removeStudent(String name);

    /**
     * Retrieves a student from the registry by their name.
     *
     * @param name the name of the student to be retrieved
     * @return an Optional containing the student if found, otherwise an empty Optional
     */
    Optional<S> getStudent(String name);

