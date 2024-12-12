package net.javaguides.demo.ems.backend.repository;

import net.javaguides.demo.ems.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
