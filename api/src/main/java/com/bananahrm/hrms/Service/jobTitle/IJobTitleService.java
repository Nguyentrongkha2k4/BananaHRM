package com.bananahrm.hrms.Service.jobTitle;

import java.util.List;

import com.bananahrm.hrms.Entity.JobTitle;

public interface IJobTitleService {
    JobTitle createJobTitle(String title) throws Exception;
    JobTitle getTitleById(Long titleId) throws Exception;
    List<JobTitle> getAllJobTitles() throws Exception;
    JobTitle updateJobTitle(Long id, String title) throws Exception;
    JobTitle deleteJobTitle(Long id) throws Exception;
}
