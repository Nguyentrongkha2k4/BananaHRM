package com.bananahrm.hrms.Rerpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bananahrm.hrms.Entity.User;

import java.util.Optional;



public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByMaNhanVien(String maNhanVien);
}
