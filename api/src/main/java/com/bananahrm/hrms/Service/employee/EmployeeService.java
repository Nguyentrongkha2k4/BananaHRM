package com.bananahrm.hrms.Service.employee;

import org.springframework.stereotype.Service;

import com.bananahrm.hrms.DTO.request.EmployeeCreationRequest;
import com.bananahrm.hrms.Entity.Department;
import com.bananahrm.hrms.Entity.Employee;
import com.bananahrm.hrms.Entity.JobTitle;
import com.bananahrm.hrms.Rerpository.EmployeeRepository;
import com.bananahrm.hrms.Service.department.IDepartmentService;
import com.bananahrm.hrms.Service.jobTitle.IJobTitleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService{
    private final EmployeeRepository employeeRepository;

    private final IJobTitleService iJobTitleService;
    private final IDepartmentService iDepartmentService;

    @Override
    public Employee createEmployee(EmployeeCreationRequest request) throws Exception {
        JobTitle jobTitle = iJobTitleService.getTitleById(request.getJobTitleId());       
        
        Department department = iDepartmentService.getDepartmentById(request.getDepartmentId());

        Employee employee = Employee.builder()
                                .jobTitleId(jobTitle.getId())
                                .departmentId(department.getId())
                                .citizenId(request.getCitizenId())
                                .address(request.getAddress())
                                .dob(request.getDob())
                                .email(request.getEmail())
                                .firstName(request.getFirstName())
                                .lastName(request.getLastName())
                                .phone(request.getPhone())
                                .status("VALID")
                                .build();

        return employeeRepository.save(employee);
    }

}
