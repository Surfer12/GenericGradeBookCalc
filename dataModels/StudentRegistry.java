package dataModels;

import java.util.Map;
import java.util.Optional;
import java.util.List;
/**
 * Interface for managing students.
 *
 * @param <S> Type of Student
 * @param <G> Type of Grade
 */
public interface StudentRegistry<S extends Student<G>, G extends Number> {
    void addStudent(S student);
    Optional<S> getStudent(String name);
    Optional<S> removeStudent(String name);
    int countStudents();
    List<S> getStudents();
    Optional<S> updateGrade(String name, int assignmentNumber, G grade);
    Map<String, S> getAllStudents();
}