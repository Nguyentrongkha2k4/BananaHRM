package com.bananahrm.hrms.Service.token;

import com.bananahrm.hrms.Entity.Token;
import com.bananahrm.hrms.Entity.User;

public interface ITokenService {
    Token addToken(User user, String token) throws Exception;
}
