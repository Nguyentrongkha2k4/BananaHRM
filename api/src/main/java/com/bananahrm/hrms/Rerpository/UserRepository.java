package com.bananahrm.hrms.Rerpository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bananahrm.hrms.Entity.User;




public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByMaNhanVien(String maNhanVien);
    boolean existsByMaNhanVien(String maNhanVien);
}
