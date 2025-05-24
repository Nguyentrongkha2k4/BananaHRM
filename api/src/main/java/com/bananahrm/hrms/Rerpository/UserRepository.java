package com.bananahrm.hrms.Rerpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bananahrm.hrms.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
