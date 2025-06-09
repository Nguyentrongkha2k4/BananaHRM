package com.bananahrm.hrms.DTO.request;

import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ForgotPassRequest {
    @Email(message = "EMAIL_INVALID")
    String email;
}
