package dataModels;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Student entities.
 */
public interface StudentRepository<S extends Student<G>, G extends Number> {
    // Define repository methods here
}