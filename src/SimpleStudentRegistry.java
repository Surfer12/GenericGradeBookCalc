import java.util.ArrayList;
import java.util.List;

public class SimpleStudentRegistry<S extends Student<?>> implements StudentRegistry<S> {
    private final List<S> students = new ArrayList<>();

    @Override
    public void addStudent(S student) {
        students.add(student);
    }

    @Override
    public List<S> getAllStudents() {
        return new ArrayList<>(students);
    }
}