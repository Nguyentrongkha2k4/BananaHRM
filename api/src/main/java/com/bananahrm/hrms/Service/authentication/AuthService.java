package com.bananahrm.hrms.Service.authentication;

import java.util.Objects;
import java.util.Optional;

import com.bananahrm.hrms.Entity.Employee;
import com.bananahrm.hrms.Rerpository.EmployeeRepository;
import com.bananahrm.hrms.Service.authRedis.IAuthRedisService;
import com.bananahrm.hrms.Service.user.IUserService;
import com.bananahrm.hrms.Util.RandomPasswordGeneration;
import com.bananahrm.hrms.kafka.dto.MailRequest;
import com.bananahrm.hrms.kafka.producer.MailProducer;
import org.springframework.kafka.core.KafkaTemplate;
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
    private final EmployeeRepository employeeRepository;
    private final IUserService iUserService;
    private final MailProducer mailProducer;
    private final IAuthRedisService iAuthRedisService;


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

    @Override
    public void getRandomCode(String email) throws Exception {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(email);

        if(employeeOptional.isEmpty()){
            throw new AppException(ErrorCode.EMAIL_INVALID);
        }

        String userName = iUserService.getUsernameByEmployeeId(employeeOptional.get().getId());

        String subject = "Access Code";
        String randCode = RandomPasswordGeneration.generateRandomPassword(5);

//        need save otp code to redis

        String body = "Hello " + userName + "!\n" + "Here is your code!\n" + randCode + "\n Sincerely";

        MailRequest mailRequest = MailRequest.builder()
                .body(body)
                .subject(subject)
                .to(email)
                .build();

        mailProducer.send(mailRequest);
    }


}
