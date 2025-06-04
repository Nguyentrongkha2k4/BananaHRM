package com.bananahrm.hrms.Controller;

import com.bananahrm.hrms.DTO.request.JobTitleRequest;
import com.bananahrm.hrms.DTO.response.JobTitleResponse;
import com.bananahrm.hrms.DTO.response.ResponseObject;
import com.bananahrm.hrms.Entity.JobTitle;
import com.bananahrm.hrms.Service.jobTitle.IJobTitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/title")
@RequiredArgsConstructor
public class JobTitleController {
    private final IJobTitleService iJobTitleService;

    @PostMapping("/add")
    ResponseObject<JobTitleResponse> handleAddJobTitle(@RequestBody JobTitleRequest request) throws Exception{
        try{
            JobTitle jobTitle = iJobTitleService.createJobTitle(request.getTitle());
            JobTitleResponse jobTitleResponse = JobTitleResponse.builder().id(jobTitle.getId()).title(jobTitle.getTitle()).build();

            return ResponseObject.<JobTitleResponse>builder().status(200).message("Add jobTitle successful.").data(jobTitleResponse).build();
        } catch (Exception e) {
            throw e;
        }
    }
}
