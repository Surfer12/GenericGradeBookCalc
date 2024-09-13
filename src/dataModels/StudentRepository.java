package dataModels;


/**
 * Repository for Student entities.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    // Additional query methods if needed
}