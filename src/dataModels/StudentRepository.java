package dataModels;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repository for Student entities.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student<Integer>, Long> {
    Optional<Student<Integer>> findByName(String name);
}