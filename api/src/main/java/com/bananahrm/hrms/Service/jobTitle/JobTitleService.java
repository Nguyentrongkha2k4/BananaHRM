package com.bananahrm.hrms.Service.jobTitle;

import com.bananahrm.hrms.Exception.AppException;
import com.bananahrm.hrms.Exception.ErrorCode;
import com.bananahrm.hrms.Rerpository.JobTitleRepository;
import org.springframework.stereotype.Service;

import com.bananahrm.hrms.Entity.JobTitle;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobTitleService implements IJobTitleService{

    private final JobTitleRepository jobTitleRepository;

    @Override
    public JobTitle createJobTitle(String title) throws Exception {
        if (title == null || title.trim().isEmpty()){
            throw new AppException(ErrorCode.TITLE_EMPTY);
        }

        if(jobTitleRepository.existsJobTitlesByTitle(title)){
            throw new AppException(ErrorCode.TITLE_EXIST);
        }

        JobTitle jobTitle = JobTitle.builder().title(title).build();

        return jobTitleRepository.save(jobTitle);
    }

    @Override
    public JobTitle getTitleById(Long titleId) throws Exception {
        Optional<JobTitle> jobTitleOptional = jobTitleRepository.findById(titleId);

        if(jobTitleOptional.isEmpty()){
            throw new AppException(ErrorCode.TITLE_NOT_FOUND);
        }

        return jobTitleOptional.get();
    }

    @Override
    public List<JobTitle> getAllJobTitles() throws Exception {
        return jobTitleRepository.findAll();
    }

    @Override
    public JobTitle updateJobTitle(Long id, String title) throws Exception {
        JobTitle jobTitle = this.getTitleById(id);

        jobTitle.setTitle(title);

        return jobTitleRepository.save(jobTitle);
    }

    @Override
    public JobTitle deleteJobTitle(Long id) throws Exception {
        JobTitle jobTitle = this.getTitleById(id);
        jobTitleRepository.delete(jobTitle);

        return jobTitle;
    }

}
