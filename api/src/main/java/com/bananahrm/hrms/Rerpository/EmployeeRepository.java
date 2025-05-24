package com.bananahrm.hrms.Rerpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bananahrm.hrms.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
