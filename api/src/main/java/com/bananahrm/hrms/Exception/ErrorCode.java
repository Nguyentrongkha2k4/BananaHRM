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
    ;
    private String message;

}
