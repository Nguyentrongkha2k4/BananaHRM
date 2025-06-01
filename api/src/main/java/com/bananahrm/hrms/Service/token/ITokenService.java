package com.bananahrm.hrms.Service.token;

import com.bananahrm.hrms.Entity.Token;
import com.bananahrm.hrms.Entity.User;

public interface ITokenService {
    public Token addToken(User user, String token) throws Exception;
    public void logout(String accessToken, String refreshToken) throws Exception;
}
