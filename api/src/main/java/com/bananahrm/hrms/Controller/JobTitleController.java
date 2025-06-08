package com.bananahrm.hrms.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bananahrm.hrms.DTO.request.JobTitleRequest;
import com.bananahrm.hrms.DTO.response.JobTitleResponse;
import com.bananahrm.hrms.DTO.response.ResponseObject;
import com.bananahrm.hrms.Entity.JobTitle;
import com.bananahrm.hrms.Service.jobTitle.IJobTitleService;
import com.bananahrm.hrms.mapper.JobTitleMapper;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/titles")
@RequiredArgsConstructor
public class JobTitleController {
    private final IJobTitleService iJobTitleService;
    private final JobTitleMapper jobTitleMapper;

    @PostMapping("")
    public ResponseObject<JobTitleResponse> handleAddJobTitle(@RequestBody JobTitleRequest request) throws Exception{
        try{
            JobTitle jobTitle = iJobTitleService.createJobTitle(request.getTitle());
            JobTitleResponse jobTitleResponse = JobTitleResponse.builder().id(jobTitle.getId()).title(jobTitle.getTitle()).build();

            return ResponseObject.<JobTitleResponse>builder().status(200).message("Add jobTitle successful.").data(jobTitleResponse).build();
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("")
    public ResponseObject<List<JobTitleResponse>> handleGetAllJobTitle() throws Exception {
        try{
            List<JobTitle> lJobTitles = iJobTitleService.getAllJobTitles();
            List<JobTitleResponse> lJobTitleResponse = lJobTitles.stream()
                    .map(jobTitleMapper::toDTO)
                    .toList();
            return ResponseObject.<List<JobTitleResponse>>builder()
                .status(200).message("Get all job title successfully.").data(lJobTitleResponse).build();
        } catch(Exception e){
            throw e;
        }
    }

    @GetMapping("/{id}")
    public ResponseObject<JobTitleResponse> handleGetJobTitleById(@PathVariable String id) throws Exception{
        try{
            JobTitle jobTitle = iJobTitleService.getTitleById(Long.parseLong(id));

            return ResponseObject.<JobTitleResponse>builder()
                    .status(200)
                    .message("Get Job Title Successfully.")
                    .data(jobTitleMapper.toDTO(jobTitle))
                    .build();
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ResponseObject<JobTitleResponse> handleUpdateJobTitle(@PathVariable String id, @RequestBody JobTitleRequest request) throws Exception{
        try{
            JobTitle jobTitle = iJobTitleService.updateJobTitle(Long.parseLong(id), request.getTitle());

            return ResponseObject.<JobTitleResponse>builder()
                    .status(200)
                    .message("Update job title successfully.")
                    .data(jobTitleMapper.toDTO(jobTitle))
                    .build();
        } catch (Exception e){
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseObject<JobTitleResponse> handleDeleteJobTitle(@PathVariable String id) throws Exception{
        try{
            JobTitle jobTitle = iJobTitleService.deleteJobTitle(Long.parseLong(id));

            return ResponseObject.<JobTitleResponse>builder()
                    .status(200)
                    .message("Delete job title successfully.")
                    .data(jobTitleMapper.toDTO(jobTitle))
                    .build();
        } catch (Exception e){
            throw e;
        }
    }
    
}
