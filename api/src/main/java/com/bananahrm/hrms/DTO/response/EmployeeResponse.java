package com.bananahrm.hrms.DTO.response;

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
    Long jobTitleId;
    Long departmentId;
}
