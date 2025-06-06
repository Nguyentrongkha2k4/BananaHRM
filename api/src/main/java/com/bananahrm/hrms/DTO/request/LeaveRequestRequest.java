package com.bananahrm.hrms.DTO.request;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LeaveRequestRequest {
    Long leaveTypeId;

    LocalDate fromDate;

    LocalDate toDate;

    String reason;

}
