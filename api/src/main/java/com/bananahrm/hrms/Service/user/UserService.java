package com.bananahrm.hrms.Service.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bananahrm.hrms.Entity.User;
import com.bananahrm.hrms.Exception.AppException;
import com.bananahrm.hrms.Exception.ErrorCode;
import com.bananahrm.hrms.Rerpository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) throws Exception {
        Optional<User> optionalUser = userRepository.findByMaNhanVien(username);
        
        if(optionalUser.isEmpty()){
            throw new AppException(ErrorCode.USERNAME_NOT_FOUND);
        }

        User existsUser = optionalUser.get();

        return existsUser;
    }
    
}
