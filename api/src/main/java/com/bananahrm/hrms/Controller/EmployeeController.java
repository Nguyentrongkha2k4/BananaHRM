package com.bananahrm.hrms.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bananahrm.hrms.DTO.request.EmployeeCreationRequest;
import com.bananahrm.hrms.DTO.response.AccountResponse;
import com.bananahrm.hrms.DTO.response.DepartmentResponse;
import com.bananahrm.hrms.DTO.response.EmployeeResponse;
import com.bananahrm.hrms.DTO.response.JobTitleResponse;
import com.bananahrm.hrms.DTO.response.ResponseObject;
import com.bananahrm.hrms.Entity.Department;
import com.bananahrm.hrms.Entity.Employee;
import com.bananahrm.hrms.Entity.JobTitle;
import com.bananahrm.hrms.Service.department.IDepartmentService;
import com.bananahrm.hrms.Service.employee.IEmployeeService;
import com.bananahrm.hrms.Service.jobTitle.IJobTitleService;
import com.bananahrm.hrms.Service.user.IUserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final IEmployeeService iEmployeeService;
    private final IUserService iUserService;
    private final IJobTitleService iJobTitleService;
    private final IDepartmentService iDepartmentService;


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

            EmployeeResponse employeeResponse = EmployeeResponse.builder()
                    .dob(employee.getDob())
                    .departmentResponse(DepartmentResponse.builder().id(department.getId()).name(department.getName()).build())
                    .jobTitleResponse(JobTitleResponse.builder().id(jobTitle.getId()).title(jobTitle.getTitle()).build())
                    .phone(employee.getPhone())
                    .email(employee.getEmail())
                    .maNhanVien(maNhanVien)
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .address(employee.getAddress())
                    .citizenId(employee.getCitizenId())
                    .role(role)
                    .build();

            return ResponseObject.<EmployeeResponse>builder()
                    .status(200)
                    .message("get user with id: " + id + " Successful")
                    .data(employeeResponse)
                    .build();
        }catch (Exception e){
            throw e;
        }
    }
    
}
