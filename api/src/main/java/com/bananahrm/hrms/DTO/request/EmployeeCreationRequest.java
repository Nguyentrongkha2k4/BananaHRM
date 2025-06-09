package com.bananahrm.hrms.DTO.request;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeCreationRequest {
    Long jobTitleId;

    Long departmentId;

    String lastName;

    String firstName;

    Long supervisorId;

    Long managerId;

    @Size(min = 12, max = 12, message = "IDENTIFY_ERROR")
    @Pattern(regexp = "[0-9]*", message = "IDENTIFY_ERROR")
    String citizenId;

    @Past(message="DOB_INVALID")
    Date dob;

    @Email(message="EMAIL_INVALID")
    String email;

    @Size(min=10, max=10, message="NUMBER_ERROR")
    @Pattern(regexp = "[0-9]*", message = "NUMBER_ERROR")
    String phone;

    String address;

    @Pattern(regexp="VALID|INVALID", message="STATUS_INVALID")
    String status;
}
