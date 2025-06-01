package com.bananahrm.hrms.Service.authentication;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bananahrm.hrms.Component.jwtAuthentication;
import com.bananahrm.hrms.Entity.User;
import com.bananahrm.hrms.Exception.AppException;
import com.bananahrm.hrms.Exception.ErrorCode;
import com.bananahrm.hrms.Rerpository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final jwtAuthentication jwtAuthen;

    @Override
    public String login(String username, String password) throws Exception{
        Optional<User> optionalUser = userRepository.findByMaNhanVien(username);
        
        if(optionalUser.isEmpty()){
            throw new AppException(ErrorCode.USERNAME_NOT_FOUND);
        }

        User existsUser = optionalUser.get();

        if(!passwordEncoder.matches(password, existsUser.getPassword())){
            throw new AppException(ErrorCode.PASSWORD_WRONG);
        }

        String token = jwtAuthen.generateToken(existsUser);
        
        return token;
    }

    @Override
    public void logout(String accessToken, String refreshToken) throws Exception {
        
    }

}
