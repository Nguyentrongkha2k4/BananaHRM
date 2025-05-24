package com.bananahrm.hrms.Component;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bananahrm.hrms.Entity.User;
import com.bananahrm.hrms.Exception.AppException;
import com.bananahrm.hrms.Exception.ErrorCode;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;


@Component
public class jwtAuthentication {
    @Value("${jwt.secret_key}")
    private String SECRET_KEY;
    
    @Value("${jwt.expirationtime}")
    private long EXPIRATION_TIME;

    public boolean checkPassword(String requestPassword, String hashPassword) throws Exception{
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(requestPassword, hashPassword);
    }

    public String generateToken(User user) throws Exception{
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                                            .subject(user.getId().toString())
                                            .issuer("dev")
                                            .issueTime(new Date())
                                            .expirationTime(
                                                new Date(Instant.now().plus(EXPIRATION_TIME, ChronoUnit.SECONDS).toEpochMilli()))
                                            .claim("scope", user.getRole())
                                            .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jWSObject = new JWSObject(jwsHeader, payload);

        jWSObject.sign(new MACSigner(SECRET_KEY.getBytes()));

        return jWSObject.serialize();
    }

    public SignedJWT parSignedJWT(String token) throws ParseException{
        SignedJWT signedJWT = SignedJWT.parse(token);
        return signedJWT;
    }

}
