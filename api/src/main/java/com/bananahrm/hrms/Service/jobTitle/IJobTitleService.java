package com.bananahrm.hrms.Service.jobTitle;

import com.bananahrm.hrms.Entity.JobTitle;

public interface IJobTitleService {
    JobTitle createJobTitle(String title) throws Exception;
    JobTitle getTitleById(Long titleId) throws Exception;
}
