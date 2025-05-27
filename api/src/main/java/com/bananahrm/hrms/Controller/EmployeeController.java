package com.bananahrm.hrms.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bananahrm.hrms.DTO.request.EmployeeCreationRequest;
import com.bananahrm.hrms.DTO.response.AccountResponse;
import com.bananahrm.hrms.DTO.response.ResponseObject;
import com.bananahrm.hrms.Entity.Employee;
import com.bananahrm.hrms.Service.employee.IEmployeeService;
import com.bananahrm.hrms.Service.user.IUserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final IEmployeeService iEmployeeService;
    private final IUserService iUserService;

    @PostMapping("/add")
    public ResponseObject<AccountResponse> postMethodName(@RequestBody EmployeeCreationRequest request) throws Exception {
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
    
}
