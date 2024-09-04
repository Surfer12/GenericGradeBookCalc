import java.util.List;
public interface GradebookDisplay<S extends Student> {
    void displayGradebook(List<S> students);
}