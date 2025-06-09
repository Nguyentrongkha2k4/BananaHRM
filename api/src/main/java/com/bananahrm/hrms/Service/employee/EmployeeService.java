package com.bananahrm.hrms.Service.employee;

import com.bananahrm.hrms.Exception.AppException;
import com.bananahrm.hrms.Exception.ErrorCode;
import org.springframework.stereotype.Service;

import com.bananahrm.hrms.DTO.request.EmployeeCreationRequest;
import com.bananahrm.hrms.Entity.Department;
import com.bananahrm.hrms.Entity.Employee;
import com.bananahrm.hrms.Entity.JobTitle;
import com.bananahrm.hrms.Rerpository.EmployeeRepository;
import com.bananahrm.hrms.Service.department.IDepartmentService;
import com.bananahrm.hrms.Service.jobTitle.IJobTitleService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

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

        Employee supervisor = this.getEmployeeById(request.getSupervisorId());

        Employee manager = this.getEmployeeById(request.getManagerId());

        Employee employee = Employee.builder()
                                .supervisorId(supervisor.getId())
                                .managerId(manager.getId())
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

    @Override
    public Employee getEmployeeById(long id) throws Exception {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()){
            throw new AppException(ErrorCode.EMPLOYEE_NOT_EXISTS);
        }

        return employeeOptional.get();
    }

    @Override
    public List<Employee> getAllEmployees() throws Exception {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(long id, EmployeeCreationRequest request) throws Exception {
        Employee oldEmployee = this.getEmployeeById(id);
        JobTitle jobTitle = iJobTitleService.getTitleById(request.getJobTitleId());
        Department department = iDepartmentService.getDepartmentById(request.getDepartmentId());
        Employee supervisor = this.getEmployeeById(request.getSupervisorId());
        Employee manager = this.getEmployeeById(request.getManagerId());

        oldEmployee.setFirstName(request.getFirstName());
        oldEmployee.setLastName(request.getLastName());
        oldEmployee.setPhone(request.getPhone());
        oldEmployee.setEmail(request.getEmail());
        oldEmployee.setAddress(request.getAddress());
        oldEmployee.setDob(request.getDob());
        oldEmployee.setJobTitleId(jobTitle.getId());
        oldEmployee.setManagerId(manager.getId());
        oldEmployee.setDepartmentId(department.getId());
        oldEmployee.setCitizenId(request.getCitizenId());
        oldEmployee.setSupervisorId(supervisor.getId());
        oldEmployee.setStatus(request.getStatus());

        return employeeRepository.save(oldEmployee);

    }

    @Override
    public void deleteEmployee(long id) throws Exception {

    }

}
