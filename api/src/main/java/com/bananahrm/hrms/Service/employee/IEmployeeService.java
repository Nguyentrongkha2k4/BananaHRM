package com.bananahrm.hrms.Service.employee;

import com.bananahrm.hrms.DTO.request.EmployeeCreationRequest;
import com.bananahrm.hrms.Entity.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee createEmployee(EmployeeCreationRequest request) throws Exception;
    Employee getEmployeeById(long id) throws Exception;
    List<Employee> getAllEmployees() throws Exception;
    Employee updateEmployee(long id, EmployeeCreationRequest request) throws Exception;
    void deleteEmployee(long id) throws Exception;
}
