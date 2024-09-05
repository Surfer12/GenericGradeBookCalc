import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface StudentRegistry<S extends Student<?>, G> {

    default List<S> getStudents() {
        return new ArrayList<>();
    }

    default void addStudent(S student) {
        getStudents().add(student);
    }

    default List<S> getAllStudents() {
        return new ArrayList<>(getStudents());
    }

    @SuppressWarnings("unused")
    default Optional<S> removeStudent(String name) {
        Optional<S> studentToRemove = getStudents().stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();
        studentToRemove.ifPresent(student -> {
            getStudents().remove(student);
            System.out.println("Student removed: " + student.getName());
        });
        if (studentToRemove.isEmpty()) {
            System.out.println("Student not found.");
        }
        return studentToRemove;
    }

    default Optional<S> getStudent(String name) {
        return getStudents().stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();
    }

    @SuppressWarnings("unused")
    default Optional<S> updateGrade(String name, int assignmentNumber, Number grade) {
        return getStudents().stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .map(student -> {
                    student.updateGrade(name, assignmentNumber, grade);
                    System.out.println("Grade updated for student: " + name);
                    return student;
                });
    }
}