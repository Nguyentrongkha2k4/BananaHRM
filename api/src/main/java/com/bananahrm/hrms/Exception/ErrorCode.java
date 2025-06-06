package com.bananahrm.hrms.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    USERNAME_INVALID("Username is invalid."),
    USERNAME_ALREADY_EXIST("Username have already exists."),
    PASSWORD_INVALID("Password is invalid."),
    USERNAME_NOT_FOUND("Username is not exists."),
    PASSWORD_WRONG("Password is incorrect."),
    INVALID_KEY("Key exception is invalid."),
    DOB_INVALID("DOB must be after now."),
    EMAIL_INVALID("Email is invalid format."),
    NUMBER_ERROR("PhoneNumber is invalid format."),
    STATUS_INVALID("Status is invalid."),
    IDENTIFY_ERROR("Identify is invalid format."),
    LOGIN_LIMIT("Login is limited"),
    EMPLOYEE_ID_INVALID("Employee account is invalid"),
    EMPLOYEE_NOT_EXISTS("Employee is not exists."),
    TITLE_EMPTY("Title can not be empty."),
    TITLE_EXIST("Title name has been exists."),
    DEPARTMENT_EMPTY("Department name can not be empty."),
    DEPARTMENT_EXIST("Department name has been exists."),
    TITLE_NOT_FOUND("Title is not founded."),
    DEPARTMENT_NOT_FOUND("Department is not founded."),
    LEAVE_REQUEST_NOT_FOUND("Leave request is not founded."),
    LEAVE_REQUEST_INVALID("Leave request is invalid."),
    ;
    private String message;

}
