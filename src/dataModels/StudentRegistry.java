package dataModels;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRegistry<S extends Student<G>, G extends Number> {
    private static StudentRegistry<?, ?> instance; // Parameterize with wildcards

    private StudentRegistry() {
        // private constructor to prevent instantiation
    }

    public static synchronized <S extends Student<G>, G extends Number> StudentRegistry<S, G> getInstance() {
        if (instance == null) {
            instance = new StudentRegistry<>();
        }
        return (StudentRegistry<S, G>) instance;
    }

    default List<S> getStudents() {
        return new ArrayList<>();
    }

    

    default void addStudent(S student) {
        getStudents().add(student);
    }

    default List<S> getAllStudents() {
        return new ArrayList<>(getStudents());
    }

    default Optional<S> removeStudent(String name) {
        Optional<S> studentToRemove = getStudents().stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();
        studentToRemove.ifPresent(student -> {
            getStudents().remove(student);
            System.out.println("Student removed: " + student.getName());
        });
        if (studentToRemove.isEmpty()) {
            if (!name.equalsIgnoreCase("STOP")) {
                System.out.println("Student not found.");
            } else {
                return Optional.empty();
            }
        }
        return studentToRemove;
    }

    default Optional<S> getStudent(String name) {
        return getStudents().stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();
    }

    default Optional<S> updateGrade(String name, int assignmentNumber, G grade) {
        return getStudents().stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .map(student -> {
                    student.updateGrade(assignmentNumber, grade); // Remove cast to Number
                    System.out.println("Grade updated for student: " + name);
                    return student;
                });
    }

    int countStudents();
}