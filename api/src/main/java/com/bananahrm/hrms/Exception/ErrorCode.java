package com.bananahrm.hrms.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    USERNAME_INVALID("Username is invalid."),
    PASSWORD_INVALID("Password is invalid."),
    USERNAME_NOT_FOUND("Username is not exists."),
    PASSWORD_WRONG("Password is incorrect."),
    ;
    private String message;

}
