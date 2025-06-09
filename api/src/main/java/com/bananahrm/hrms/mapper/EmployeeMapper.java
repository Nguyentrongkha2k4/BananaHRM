package com.bananahrm.hrms.mapper;

import com.bananahrm.hrms.DTO.response.EmployeeResponse;
import com.bananahrm.hrms.Entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface EmployeeMapper {
    EmployeeResponse toDTO(Employee employee);
}
