import java.util.List;

public interface GradebookDisplay<S extends Student<?>> {
    void display(List<S> students);
}