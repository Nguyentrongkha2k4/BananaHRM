package com.bananahrm.hrms.mapper;

import com.bananahrm.hrms.DTO.response.DepartmentResponse;
import com.bananahrm.hrms.Entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentResponse toDTO(Department department);
}
