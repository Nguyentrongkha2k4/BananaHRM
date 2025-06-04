package com.bananahrm.hrms.Service.user;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bananahrm.hrms.DTO.response.AccountResponse;
import com.bananahrm.hrms.Entity.Employee;
import com.bananahrm.hrms.Entity.User;
import com.bananahrm.hrms.Exception.AppException;
import com.bananahrm.hrms.Exception.ErrorCode;
import com.bananahrm.hrms.Rerpository.UserRepository;
import com.bananahrm.hrms.Util.RandomPasswordGeneration;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User getUserByUsername(String username) throws Exception {
        Optional<User> optionalUser = userRepository.findByMaNhanVien(username);
        
        if(optionalUser.isEmpty()){
            throw new AppException(ErrorCode.USERNAME_NOT_FOUND);
        }

        User existsUser = optionalUser.get();

        return existsUser;
    }

    

    @Override
    public AccountResponse createEmployeeAccount(Employee employee) throws Exception {

        // Get the last two digits of the current year (e.g., 2025 -> "25")
        String yearSuffix = String.valueOf(Year.now().getValue()).substring(2);

        // Get the last two digits of the date of birth (e.g., 2004 -> "04")
        SimpleDateFormat formatter = new SimpleDateFormat("yy");
        String DobSuffix = formatter.format(employee.getDob()); 

        // Get the last three digits of the citizen ID (e.g., 00113 -> "113")
        String IDSuffix = employee.getCitizenId().substring(3);

        // Gen password randomly
        String randomPassword = RandomPasswordGeneration.generateRandomPassword(5);
        
        String maNhanVien;

        // Increase last digits until maNhanVien is unique in database
        int index = 0;
        do {
            maNhanVien = "EMP" + yearSuffix + DobSuffix + IDSuffix + String.format("%03d", index); // VD: "NV001", "NV002"
            index++;
        } while (userRepository.existsByMaNhanVien(maNhanVien));

        // Create Account
        createUser(maNhanVien, randomPassword, employee);

        return AccountResponse.builder().username(maNhanVien).password(randomPassword).build();
    }

    @Override
    public String getUsernameByEmployeeId(Long id) throws Exception {
        Optional<User> user = userRepository.findByEmployeeId(id);
        if(user.isEmpty()){
            throw new AppException(ErrorCode.EMPLOYEE_ID_INVALID);
        }

        User findUser = user.get();

        return findUser.getMaNhanVien();
    }

    @Override
    public String getRoleByEmployeeId(Long id) throws Exception {
        Optional<User> user = userRepository.findByEmployeeId(id);
        if(user.isEmpty()){
            throw new AppException(ErrorCode.EMPLOYEE_ID_INVALID);
        }

        User findUser = user.get();

        return findUser.getRole();
    }


    @Override
    public void createUser(String username, String password, Employee employee) throws Exception {
        if (userRepository.existsByMaNhanVien(username)){
            throw new AppException(ErrorCode.USERNAME_ALREADY_EXIST);
        }

        User newAccount = User.builder()
                            .employeeId(employee.getId())
                            .maNhanVien(username)
                            .password(passwordEncoder.encode(password))
                            .role("EMP")
                            .build();

        userRepository.save(newAccount);
    }
    
}
