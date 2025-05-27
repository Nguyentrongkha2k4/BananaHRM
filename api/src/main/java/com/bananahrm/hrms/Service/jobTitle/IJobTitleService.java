package com.bananahrm.hrms.Service.jobTitle;

import com.bananahrm.hrms.Entity.JobTitle;

public interface IJobTitleService {
    JobTitle getTitleById(Long titleId) throws Exception;
}
