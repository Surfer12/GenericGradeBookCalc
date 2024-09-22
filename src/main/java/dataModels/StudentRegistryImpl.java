package main.java.dataModels;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentRegistryImpl<S extends Student<G>, G extends Number> implements StudentRegistry<S, G> {
    private final List<S> students = new ArrayList<>();

    public StudentRegistryImpl() {
        super();
    }

    @Override
    public List<S> getStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public void addStudent(S student) {
        if (student != null) {
            students.add(student);
        }
    }

    @Override
    public Optional<S> removeStudent(String name) {
        return getStudent(name).map(student -> {
            students.remove(student);
            return student;
        });
    }

    @Override
    public Optional<S> getStudent(String name) {
        return students.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();
    }

    @Override
    public int countStudents() {
        return students.size();
    }

    @Override
    public Map<String, S> getAllStudents() {
        return students.stream()
                .collect(Collectors.toMap(Student::getName, Function.identity()));
    }

    @Override
    public Optional<S> updateGrade(String name, int assignmentNumber, G grade) {
        return getStudent(name).map(student -> {
            student.addGrade(grade);
            System.out.println("Grade updated for student: " + name);
            return student;
        });
    }
}