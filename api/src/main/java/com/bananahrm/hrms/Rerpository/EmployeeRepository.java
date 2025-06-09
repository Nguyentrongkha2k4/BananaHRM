package com.bananahrm.hrms.Rerpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bananahrm.hrms.Entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    Optional<Employee> findEmployeeByEmail(String email);
}
