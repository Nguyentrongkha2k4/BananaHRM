package com.bananahrm.hrms.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bananahrm.hrms.DTO.request.LoginRequest;
import com.bananahrm.hrms.DTO.response.LoginResponse;
import com.bananahrm.hrms.DTO.response.ResponseObject;
import com.bananahrm.hrms.Service.authentication.IAuthService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService authService;

    @PostMapping("/login")
    public ResponseObject<LoginResponse> postMethodName(@RequestBody LoginRequest request) {
        try {
            // String token = authService;
            return ResponseObject.<LoginResponse>builder()
                        .status(200)
                        .message("Login success")
                        // .data(LoginResponse.builder().token(token).refresh_token(token).build())
                        .build();     
        } catch (Exception e) {
            throw e;
        }
    }
    
}
