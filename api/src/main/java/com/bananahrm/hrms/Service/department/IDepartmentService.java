package com.bananahrm.hrms.Service.department;

import com.bananahrm.hrms.Entity.Department;

public interface IDepartmentService {
    Department createDepartment(String name) throws Exception;
    Department getDepartmentById(Long id) throws Exception;
}
