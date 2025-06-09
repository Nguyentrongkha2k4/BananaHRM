package com.bananahrm.hrms.Controller;

import com.bananahrm.hrms.DTO.response.*;
import com.bananahrm.hrms.Entity.Department;
import com.bananahrm.hrms.Entity.JobTitle;
import com.bananahrm.hrms.Service.department.IDepartmentService;
import com.bananahrm.hrms.Service.jobTitle.IJobTitleService;
import com.bananahrm.hrms.mapper.EmployeeMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.bananahrm.hrms.DTO.request.EmployeeCreationRequest;
import com.bananahrm.hrms.Entity.Employee;
import com.bananahrm.hrms.Service.employee.IEmployeeService;
import com.bananahrm.hrms.Service.user.IUserService;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final IEmployeeService iEmployeeService;
    private final IUserService iUserService;
    private final IJobTitleService iJobTitleService;
    private final IDepartmentService iDepartmentService;
    private final EmployeeMapper employeeMapper;

//    @PreAuthorize("hasRole('ADMIN') or hasRole('HR')")
    @PostMapping("")
    public ResponseObject<AccountResponse> handleAddEmployee(@RequestBody EmployeeCreationRequest request) throws Exception {
        try{
            Employee employee = iEmployeeService.createEmployee(request);
            AccountResponse accountResponse = iUserService.createEmployeeAccount(employee);
            
            return ResponseObject.<AccountResponse>builder()
                            .status(200)
                            .message("Create new employee successfully")
                            .data(accountResponse)
                            .build();
        }catch(Exception e){
            throw e;
        }
        
    }

    @GetMapping("/{id}")
    public ResponseObject<EmployeeResponse> getEmployee(@PathVariable String id) throws Exception {
        try{
            Employee employee = iEmployeeService.getEmployeeById(Long.parseLong(id));
            JobTitle jobTitle = iJobTitleService.getTitleById(employee.getJobTitleId());
            Department department = iDepartmentService.getDepartmentById(employee.getDepartmentId());
            String maNhanVien = iUserService.getUsernameByEmployeeId(employee.getId());
            String role = iUserService.getRoleByEmployeeId(employee.getId());

            EmployeeResponse employeeResponse = employeeMapper.toDTO(employee);

            employeeResponse.setRole(role);
            employeeResponse.setMaNhanVien(maNhanVien);

            return ResponseObject.<EmployeeResponse>builder()
                    .status(200)
                    .message("get user with id: " + id + " Successful")
                    .data(employeeResponse)
                    .build();
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("")
    public ResponseObject<List<EmployeeResponse>> getAllEmployees() throws Exception {
        try{
            List<Employee> employees = iEmployeeService.getAllEmployees();

            List<EmployeeResponse> employeesResponse = employees.stream().map(employeeMapper::toDTO).toList();

            return ResponseObject.<List<EmployeeResponse>>builder()
                    .status(200)
                    .message("get all employees")
                    .data(employeesResponse)
                    .build();
        }catch (Exception e){
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ResponseObject<EmployeeResponse> updateEmployee(@PathVariable Long id, @RequestBody EmployeeCreationRequest request) throws Exception {
        try{
            Employee employee = iEmployeeService.updateEmployee(id, request);

            return ResponseObject.<EmployeeResponse>builder()
                    .status(200)
                    .message("update employee")
                    .data(employeeMapper.toDTO(employee))
                    .build();
        }catch (Exception e){
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseObject<Void> deleteEmployee(@PathVariable Long id) throws Exception {
        try{
            iEmployeeService.deleteEmployee(id);

            return ResponseObject.<Void>builder()
                    .status(200)
                    .message("delete employee")
                    .build();
        }catch (Exception e){
            throw e;
        }
    }
    
}
