package dk.kea.restdemodat20b.repository;

import dk.kea.restdemodat20b.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
