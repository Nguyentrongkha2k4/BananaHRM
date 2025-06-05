package com.bananahrm.hrms.Service.department;

import com.bananahrm.hrms.Entity.Department;
import com.bananahrm.hrms.Entity.JobTitle;

import java.util.List;

public interface IDepartmentService {
    Department createDepartment(String name) throws Exception;
    Department getDepartmentById(Long id) throws Exception;
    List<Department> getAllDepartment() throws Exception;
    Department updateDepartment(Long id, String name) throws Exception;
    Department deleteDepartment(Long id) throws Exception;
}
