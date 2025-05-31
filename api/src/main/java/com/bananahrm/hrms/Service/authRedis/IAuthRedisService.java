package com.bananahrm.hrms.Service.authRedis;

public interface IAuthRedisService {
    public void clear() throws Exception;
    public void saveAccessToken(String token, Long userId, long ttlSecond) throws Exception;
    public void saveRefreshToken(String refreshToken, Long userId, long ttlSecond) throws Exception;
    public boolean validateAccessToken(String token) throws Exception;
    public boolean validateRefreshToken(String refreshToken) throws Exception;
    public void revokeAccessToken(String token) throws Exception;
    public void revokeRefreshToken(String refreshToken) throws Exception;
    public void deleteTokenForUser(Long userId) throws Exception;
    public boolean checkLoginFail(String username) throws Exception;
    public void handleLoginFail(String username) throws Exception;
}
