package lt.techin.zoo.dao;

import lt.techin.zoo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

// findStoreByLocationId

}
