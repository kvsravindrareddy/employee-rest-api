package com.basha.repo;

import com.basha.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface provides the Crud operations for the {@code Employee}
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}