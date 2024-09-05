import java.util.ArrayList;
import java.util.List;

public class SimpleStudentRegistry<S extends Student<?>> implements StudentRegistry<S, Number> {
    private final List<S> students = new ArrayList<>();

    @Override
    public List<S> getStudents() {
        return students;
    }
}