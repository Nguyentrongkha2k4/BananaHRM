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
    ;
    private String message;

}
