package com.bananahrm.hrms.Component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class jwtAuthentication {
    @Value("${jwt.secret_key}")
    private String SECRET_KEY;
    

}
