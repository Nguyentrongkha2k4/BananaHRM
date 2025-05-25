package com.bananahrm.hrms.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bananahrm.hrms.DTO.request.LoginRequest;
import com.bananahrm.hrms.DTO.response.LoginResponse;
import com.bananahrm.hrms.DTO.response.ResponseObject;
import com.bananahrm.hrms.Entity.Token;
import com.bananahrm.hrms.Entity.User;
import com.bananahrm.hrms.Service.authentication.IAuthService;
import com.bananahrm.hrms.Service.token.ITokenService;
import com.bananahrm.hrms.Service.user.IUserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService authService;
    private final ITokenService tokenService;
    private final IUserService userService;

    @PostMapping("/login")
    public ResponseObject<LoginResponse> postMethodName(@RequestBody LoginRequest request) throws Exception {
        try {
            String token = authService.login(request.getUsername(), request.getPassword());
            
            User user = userService.getUserByUsername(request.getUsername());

            Token jwtToken = tokenService.addToken(user, token);

            return ResponseObject.<LoginResponse>builder()
                        .status(200)
                        .message("Login success")
                        .data(LoginResponse.builder()
                                    .token(jwtToken.getToken())
                                    .refresh_token(jwtToken.getRefreshToken())
                                    .build())
                        .build();     
        } catch (Exception e) {
            throw e;
        }
    }
    
}
