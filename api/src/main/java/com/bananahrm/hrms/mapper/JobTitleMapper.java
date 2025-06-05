package com.bananahrm.hrms.mapper;

import com.bananahrm.hrms.DTO.response.JobTitleResponse;
import com.bananahrm.hrms.Entity.JobTitle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobTitleMapper {
    JobTitleResponse toDTO(JobTitle jobTitle);
}
