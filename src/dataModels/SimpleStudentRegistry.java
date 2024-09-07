package dataModels;

import java.util.ArrayList;
import java.util.List;

public class SimpleStudentRegistry<S extends Student<G>, G> implements StudentRegistry<S, G> {
    private final List<S> students = new ArrayList<>();

    @Override
    public List<S> getStudents() {
        return students;
    }
}