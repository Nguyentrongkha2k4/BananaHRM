package com.bananahrm.hrms.Service.authentication;

import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService{

    @Override
    public String login(String username, String password) {
        String token = "";
        return token;
    }

}
