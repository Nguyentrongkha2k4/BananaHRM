package com.bananahrm.hrms.Service.authentication;

public interface IAuthService {
    public String login(String username, String password) throws Exception;
    public void logout(String accessToken, String refreshToken) throws Exception;
    public void getRandomCode(String email) throws Exception;
}
