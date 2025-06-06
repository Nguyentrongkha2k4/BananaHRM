package com.bananahrm.hrms.mapper;

import com.bananahrm.hrms.DTO.response.LeaveRequestResponse;
import com.bananahrm.hrms.Entity.LeaveRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveRequestMapper {
    public LeaveRequestResponse toDTO(LeaveRequest leaveRequest);
}
