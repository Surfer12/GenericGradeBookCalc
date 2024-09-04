import java.util.ArrayList;
import java.util.List;

/**
 * The SimpleStudentRegistry class implements the StudentRegistry interface for Student objects.
 * It provides methods to add a student to the registry and retrieve all students.
 *
 * @param <S> the type of Student
 */
public class SimpleStudentRegistry<S extends Student<?>> implements StudentRegistry<S> {
    // List to store students
    private final List<S> students = new ArrayList<>();

    /**
     * Adds a student to the registry.
     *
     * @param student the student to be added
     */
    @Override
    public void addStudent(S student) {
        students.add(student);
    }

    /**
     * Retrieves all students from the registry.
     *
     * @return a list of all students
     */
    @Override
    public List<S> getAllStudents() {
        return new ArrayList<>(students);
    }
}