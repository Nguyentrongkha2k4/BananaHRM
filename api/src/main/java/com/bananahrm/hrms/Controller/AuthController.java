package com.bananahrm.hrms.Controller;

import com.bananahrm.hrms.DTO.request.ForgotPassRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bananahrm.hrms.DTO.request.LoginRequest;
import com.bananahrm.hrms.DTO.request.LogoutRequest;
import com.bananahrm.hrms.DTO.response.LoginResponse;
import com.bananahrm.hrms.DTO.response.ResponseObject;
import com.bananahrm.hrms.Entity.Token;
import com.bananahrm.hrms.Entity.User;
import com.bananahrm.hrms.Exception.AppException;
import com.bananahrm.hrms.Exception.ErrorCode;
import com.bananahrm.hrms.Service.authRedis.IAuthRedisService;
import com.bananahrm.hrms.Service.authentication.IAuthService;
import com.bananahrm.hrms.Service.token.ITokenService;
import com.bananahrm.hrms.Service.user.IUserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService iAuthService;
    private final ITokenService tokenService;
    private final IUserService userService;
    private final IAuthRedisService iAuthRedisService;

    @PostMapping("/login")
    public ResponseObject<LoginResponse> handleLogin(@RequestBody LoginRequest request) throws Exception{
        try {
            if(iAuthRedisService.checkLoginFail(request.getUsername())){
                throw new AppException(ErrorCode.LOGIN_LIMIT);
            }
            String token = iAuthService.login(request.getUsername(), request.getPassword());
            
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
            iAuthRedisService.handleLoginFail(request.getUsername());
            throw e;
        }
    }


    @PostMapping("/logout")
    public ResponseObject<String> handleLogout(@RequestBody LogoutRequest request) throws Exception{
        try {
            tokenService.logout(request.getAccessToken(), request.getRefreshToken());
            
            return ResponseObject.<String>builder().status(200).message("Logout success.").build();
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/forgot-password")
    public ResponseObject<Void> handleForgotPass(@RequestBody ForgotPassRequest request) throws Exception{
        try{
            iAuthService.getRandomCode(request.getEmail());

            return ResponseObject.<Void>builder()
                    .status(200)
                    .message("Sending random code to email.")
                    .build();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
