import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
/**
 * Removes a student from the registry by their name.
 *
 * @param name the name of the student to be removed
 * @return an Optional containing the removed student if found, otherwise an empty Optional
 */
@Override
public Optional<S> removeStudent(String name) {
    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).getName().equals(name)) {
            S removedStudent = students.remove(i);
            System.out.println("Student removed: " + removedStudent.getName());
            return Optional.of(removedStudent);
        }
    }
    System.out.println("Student not found.");
    return Optional.empty();
}


    /**
     The stream API in Java provides a functional approach to processing collections of objects. Here's a step-by-step explanation of how the stream API is used in the revised getStudent method:
     Convert the List to a Stream:
     students.stream()
     This converts the students list into a stream, allowing for functional operations on the elements of the list.
     Filter the Stream:
     .filter(student -> student.getName().equals(name))
     The filter method takes a predicate (a function that returns a boolean) and returns a new stream that includes only the elements that match the predicate. In this case, it filters the stream to include only students whose name matches the given name.
     Find the First Matching Element:
     .findFirst();
     The findFirst method returns an Optional containing the first element of the stream that matches the filter criteria. If no elements match, it returns an empty Optional. */

/**
 * Retrieves a student from the registry by their name.
 *
 * @param name the name of the student to be retrieved
 * @return an Optional containing the student if found, otherwise an empty Optional
 */
@Override
public Optional<S> getStudent(String name) {
    Optional<S> student = students.stream()
                                  .filter(s -> s.getName().equals(name))
                                  .findFirst();
    if (student.isEmpty()) {
        System.out.println("Student not found.");
    }
    return student;
}
}
