package com.bananahrm.hrms.DTO.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class LoginRequest {
    @Size(min=8, max=15, message="USERNAME_INVALID")
    String username;

    @Size(min=5, max=15, message="PASSWORD_INVALID")
    @Pattern(regexp="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[!@#$%^&*()_+\\\\-=]).{8,}$", message="PASSWORD_INVALID")
    String password;
}
