package com.bananahrm.hrms.mapper;

import com.bananahrm.hrms.DTO.response.LeaveRequestResponse;
import com.bananahrm.hrms.Entity.LeaveRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@FieldDefaults(level = AccessLevel.PUBLIC)
public interface LeaveRequestMapper {
    @Mapping(target = "updateBy", ignore = true)
    @Mapping(target = "leaveType", ignore = true)
    @Mapping(target = "maNhanVien", ignore = true)
    public LeaveRequestResponse toDTO(LeaveRequest leaveRequest);
}
