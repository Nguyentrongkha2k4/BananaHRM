package com.bananahrm.hrms.Service.employee;

import com.bananahrm.hrms.DTO.request.EmployeeCreationRequest;
import com.bananahrm.hrms.Entity.Employee;

public interface IEmployeeService {
    Employee createEmployee(EmployeeCreationRequest request) throws Exception;
    Employee getEmployeeById(long id) throws Exception;
}
