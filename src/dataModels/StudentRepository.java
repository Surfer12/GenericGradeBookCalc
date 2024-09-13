package dataModels;
import dataModels.Student;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

/**
 * Repository for Student entities.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    // Additional query methods if needed
}