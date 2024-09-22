package src.main.dataModels;


import io.micronaut.context.annotation.Bean;
import dataModels.Student;
import dataModels.StudentRepository;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Singleton StudentRegistry to manage students.
 *
 * @param <S> Type of Student
 * @param <G> Type of Grade
 */
@Singleton
public class StudentRegistry<S extends Student<G>, G extends Number> {
    private static StudentRegistry<?, ?> instance;
    private final Map<String, S> students;

    private StudentRegistry() {
        students = new HashMap<>();
    }

    public static synchronized <S extends Student<G>, G extends Number> StudentRegistry<S, G> getInstance() {
        if (instance == null) {
            instance = new StudentRegistry<>();
        }
        @SuppressWarnings("unchecked")
        StudentRegistry<S, G> castedInstance = (StudentRegistry<S, G>) instance;
        return castedInstance;
    }

    public void addStudent(S student) {
        students.put(student.getName(), student);
    }

    public Optional<S> getStudent(String name) {
        return Optional.ofNullable(students.get(name));
    }

    public void removeStudent(String name) {
        students.remove(name);
    }

    public int countStudents() {
        return students.size();
    }

    public Map<String, S> getAllStudents() {
        return new HashMap<>(students);
    }
}