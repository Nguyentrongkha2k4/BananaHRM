package com.bananahrm.hrms.DTO.response;

import com.bananahrm.hrms.Entity.LeaveType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LeaveRequestResponse {
    String maNhanVien;
    EmployeeResponse employee;
    LeaveType leaveType;
    EmployeeResponse updateBy;
    LocalDate fromDate;
    LocalDate toDate;
    String reason;
}
