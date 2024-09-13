package dataModels;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Singleton StudentRegistry to manage students.
 *
 * @param <S> Type of Student
 * @param <G> Type of Grade
 */
public class StudentRegistry<S extends Student<G>, G extends Number> {
    private static StudentRegistry<?, ?> instance;
    private List<S> students;

    // Change the constructor to public
    public StudentRegistry() {
        students = new ArrayList<>();
    }

    // Alternatively, provide a public static factory method
    public static <S extends Student<G>, G extends Number> StudentRegistry<S, G> createRegistry() {
        return new StudentRegistry<>();
    }

    @SuppressWarnings("unchecked")
    public static synchronized <S extends Student<G>, G extends Number> StudentRegistry<S, G> getInstance() {
        if (instance == null) {
            instance = new StudentRegistry<>();
        }
        @SuppressWarnings("unchecked")
        StudentRegistry<S, G> castedInstance = (StudentRegistry<S, G>) instance;
        return castedInstance;
    }

    public List<S> getStudents() {
        return new ArrayList<>(students);
    }

    public void addStudent(S student) {
        students.add(student);
    }

    public Optional<S> removeStudent(String name) {
        Optional<S> studentToRemove = students.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();
        studentToRemove.ifPresent(student -> {
            students.remove(student);
            System.out.println("Student removed: " + student.getName());
        });
        if (studentToRemove.isEmpty() && !name.equalsIgnoreCase("STOP")) {
            System.out.println("Student not found.");
        }
        return studentToRemove;
    }

    public Optional<S> getStudent(String name) {
        return students.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();
    }

    public Optional<S> updateGrade(String name, int assignmentNumber, G grade) {
        return students.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .map(student -> {
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