package com.bananahrm.hrms.Rerpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bananahrm.hrms.Entity.Token;
import java.util.List;


public interface TokenRepository extends JpaRepository<Token, Long>{
    List<Token> findByUserId(Long userId);
}
