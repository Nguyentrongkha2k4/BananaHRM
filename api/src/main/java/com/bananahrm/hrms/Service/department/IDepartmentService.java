package com.bananahrm.hrms.Service.department;

import com.bananahrm.hrms.Entity.Department;

public interface IDepartmentService {
    Department getDepartmentById(Long id) throws Exception;
}
