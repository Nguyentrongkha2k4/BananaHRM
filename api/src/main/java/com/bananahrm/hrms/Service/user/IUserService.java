package com.bananahrm.hrms.Service.user;

import com.bananahrm.hrms.DTO.response.AccountResponse;
import com.bananahrm.hrms.Entity.Employee;
import com.bananahrm.hrms.Entity.User;

public interface IUserService {
    User createUser(String username, String password, Employee employee) throws Exception;
    User getUserByUsername(String username) throws Exception;
    AccountResponse createEmployeeAccount(Employee employee) throws Exception;
}
