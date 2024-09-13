package dataModels;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Singleton StudentRegistry to manage students.
 *
 * @param <S> Type of Student
 * @param <G> Type of Grade
 */
@Singleton
public class StudentRegistry<S extends Student<G>, G extends Number> {
    private static final StudentRegistry<?, ?> INSTANCE = new StudentRegistry<>();

    @SuppressWarnings("unchecked")
    public static <S extends Student<G>, G extends Number> StudentRegistry<S, G> getInstance() {
        return (StudentRegistry<S, G>) INSTANCE;
    }

    public List<S> getStudents() {
        return new ArrayList<>(students);
    }

    public void addStudent(S student) {
        if (student != null) {
            students.add(student);
        }
    }

    public Optional<S> removeStudent(String name) {
        return getStudent(name).map(student -> {
            students.remove(student);
            System.out.println("Student removed: " + student.getName());
            return student;
        });
    }

    public Optional<S> getStudent(String name) {
        return students.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();
    }

    public Optional<S> updateGrade(String name, int assignmentNumber, G grade) {
        return getStudent(name).map(student -> {
            student.addGrade(grade);
            System.out.println("Grade updated for student: " + name);
            return student;
        });
    }

    public int countStudents() {
        return students.size();
    }

    public List<S> getAllStudents() {
        return new ArrayList<>(students);
    }
}