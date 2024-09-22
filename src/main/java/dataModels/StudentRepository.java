package dataModels;

import java.util.List;

public interface StudentRepository<S extends Student<G>, G extends Number> {
    S findById(Long id);

    List<S> findAll();

    S save(S student);

    void deleteById(Long id);
}