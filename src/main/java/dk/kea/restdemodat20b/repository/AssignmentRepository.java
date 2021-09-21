package dk.kea.restdemodat20b.repository;

import dk.kea.restdemodat20b.model.Assignment;
import org.springframework.data.repository.CrudRepository;

public interface AssignmentRepository extends CrudRepository<Assignment, Long> {
}
