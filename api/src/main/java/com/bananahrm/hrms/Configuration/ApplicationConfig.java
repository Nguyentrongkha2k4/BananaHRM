package com.bananahrm.hrms.Configuration;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.bananahrm.hrms.Entity.User;
import com.bananahrm.hrms.Rerpository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final PasswordEncoder passwordEncoder;

    @Bean
    public ApplicationRunner applicationRunner(UserRepository userRepository){
        return args->{
            if(!userRepository.existsByMaNhanVien("admin")){
                User admin = User.builder()
                                .maNhanVien("admin")
                                .password(passwordEncoder.encode("admin123"))
                                .role("ADMIN")
                                .build();
                
                userRepository.save(admin);
            }
        };
    }
}
