package com.bananahrm.hrms.DTO.response;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponse {
    String maNhanVien;
    String lastName;
    String firstName;
    Date dob;
    String citizenId;
    String email;
    String phone;
    String address;
    String status;
    String role;
    JobTitleResponse jobTitleResponse;
    DepartmentResponse departmentResponse;
}
