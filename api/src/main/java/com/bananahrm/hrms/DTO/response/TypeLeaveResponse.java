package com.bananahrm.hrms.DTO.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeLeaveResponse {
    Long id;
    String name;
}
