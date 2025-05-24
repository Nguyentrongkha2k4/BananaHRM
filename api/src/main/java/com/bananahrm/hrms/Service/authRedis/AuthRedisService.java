package com.bananahrm.hrms.Service.authRedis;

import java.time.Duration;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthRedisService implements IAuthRedisService{
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void clear() throws Exception{
        // redisTemplate.getConnectionFactory().getConnection().flushAll();
        return;
    }

    @Override
    public void saveAccessToken(String token, Long userId, long ttlSecond) throws Exception{
        String key = "access_token:" + token;
        redisTemplate.opsForValue().set(key, userId, Duration.ofSeconds(ttlSecond));
    }

    @Override
    public void saveRefreshToken(String refreshToken, Long userId, long ttlSecond) throws Exception{
        String key = "refresh_token:" + refreshToken;
        redisTemplate.opsForValue().set(key, userId, Duration.ofSeconds(ttlSecond));
    }

    @Override
    public boolean validateAccessToken(String token) throws Exception{
        String key = "access_token:"+token;
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    @Override
    public boolean validateRefreshToken(String refreshToken) throws Exception{
        String key = "refresh_token:"+refreshToken;
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    @Override
    public void revokeAccessToken(String token) throws Exception{
        String key = "access_token:" + token;
        redisTemplate.delete(key);
    }

    @Override
    public void revokeRefreshToken(String refreshToken) throws Exception{
        String key = "refresh_token:" + refreshToken;
        redisTemplate.delete(key);
    }

    @Override
    public void deleteTokenForUser(Long userId) throws Exception{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTokenForUser'");
    }

}
