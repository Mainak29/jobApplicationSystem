package com.first.JobApplication.job;

import java.util.List;

public interface JobService {

    List<Job> getAllJobs(Long companyId);
    boolean CreateJob(Job job,Long companyId);
    Job getJobById(Long id);
    boolean deleteJobById(Long id);
    Job updateJobById(Long id, Job updateJob);
}
