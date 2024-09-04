import java.util.List;
public interface StudentRegistry<S extends Student> {
    void addStudent(S student);

    List<S> getAllStudents();
}
