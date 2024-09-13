package dataModels;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Student entities.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    // Additional query methods if needed
}