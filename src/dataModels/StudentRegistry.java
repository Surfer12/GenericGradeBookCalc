package dataModels;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRegistry<S extends Student<G>, G extends Number> {
    private static class Holder<S extends Student<G>, G extends Number> {
        private static final StudentRegistry<?, ?> INSTANCE = new StudentRegistry<>();
    }

    public static synchronized <S extends Student<G>, G extends Number> StudentRegistry<S, G> getInstance() {
        @SuppressWarnings("unchecked")
        StudentRegistry<S, G> instance = (StudentRegistry<S, G>) Holder.INSTANCE;
        return instance;
    }

    private List<S> students;

    protected StudentRegistry() {
        students = new ArrayList<>();
    }

    public List<S> getStudents() {
        return new ArrayList<>(students);
    }

    public void addStudent(S student) {
        students.add(student);
    }

    public List<S> getAllStudents() {
        return new ArrayList<>(students);
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
}