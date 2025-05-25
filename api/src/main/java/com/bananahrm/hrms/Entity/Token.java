package com.bananahrm.hrms.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tokens")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Token {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    @Column(name="user_id")
    Long userId;

    String token;

    @Column(name="token_type")
    String tokenType;

    @Column(name="is_mobile")
    boolean isMobile;

    @Column(name="expiration_date")
    LocalDateTime expirationDate;

    boolean revoked;

    boolean expired;

    @Column(name="refresh_token")
    String refreshToken;

    @Column(name="refresh_expiration_date")
    LocalDateTime refreshExpirationDate;
}
