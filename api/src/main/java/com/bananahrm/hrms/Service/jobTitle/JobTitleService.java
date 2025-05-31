package com.bananahrm.hrms.Service.jobTitle;

import org.springframework.stereotype.Service;

import com.bananahrm.hrms.Entity.JobTitle;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobTitleService implements IJobTitleService{

    @Override
    public JobTitle getTitleById(Long titleId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitleById'");
    }

}
