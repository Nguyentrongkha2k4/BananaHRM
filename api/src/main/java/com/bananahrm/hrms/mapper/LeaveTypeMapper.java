package com.bananahrm.hrms.mapper;

import com.bananahrm.hrms.DTO.response.LeaveTypeResponse;
import com.bananahrm.hrms.Entity.LeaveType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveTypeMapper {
    public LeaveTypeResponse toDTO(LeaveType leaveType);
}
