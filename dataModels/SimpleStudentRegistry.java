package src.main.dataModels;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleStudentRegistry<S extends Student<G>, G extends Number> extends StudentRegistryImpl<S, G> {
    private final List<S> students = new ArrayList<>();

    public SimpleStudentRegistry() {
        super();
    }

    @Override
    public List<S> getStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public void addStudent(S student) {
        students.add(student);
    }

    @Override
    public Optional<S> removeStudent(String name) {
        Optional<S> studentToRemove = getStudent(name);
        studentToRemove.ifPresent(students::remove);
        return studentToRemove;
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
}