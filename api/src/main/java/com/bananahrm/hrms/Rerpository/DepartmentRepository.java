package com.bananahrm.hrms.Rerpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bananahrm.hrms.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
