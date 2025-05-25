package com.bananahrm.hrms.Service.token;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bananahrm.hrms.Entity.Token;
import com.bananahrm.hrms.Entity.User;
import com.bananahrm.hrms.Rerpository.TokenRepository;
import com.bananahrm.hrms.Service.authRedis.AuthRedisService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenService implements ITokenService{

    private static final int MAX_TOKEN = 3;

    @Value("${jwt.expirationtime}")
    private long EXPIRATION_TIME;
    @Value("${jwt.refreshexpirationtime}")
    private long REFRESH_EXPIRATION_TIME;

    private final TokenRepository tokenRepository;
    private final AuthRedisService authRedisService;

    @Override
    public Token addToken(User user, String token) throws Exception {
        List<Token> userToken = tokenRepository.findByUserId(user.getId());
        int tokenCount = userToken.size();

        if(tokenCount > MAX_TOKEN){
            Token tokenDelete = userToken.get(0);

            tokenRepository.delete(tokenDelete);

            authRedisService.revokeAccessToken(tokenDelete.getToken());
            authRedisService.revokeRefreshToken(tokenDelete.getRefreshToken());
        }

        long expirationInSeconds = EXPIRATION_TIME;
        long refreshExpirationTime = REFRESH_EXPIRATION_TIME;

        Token newToken = Token.builder()
                            .userId(user.getId())
                            .token(token)
                            .isMobile(false)
                            .expirationDate(LocalDateTime.now().plusSeconds(expirationInSeconds))
                            .revoked(false)
                            .expired(false)
                            .build();

        String refreshToken = UUID.randomUUID().toString();

        newToken.setRefreshToken(refreshToken);
        newToken.setRefreshExpirationDate(LocalDateTime.now().plusSeconds(refreshExpirationTime));

        return tokenRepository.save(newToken);

    }

}
