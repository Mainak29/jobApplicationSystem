package com.first.JobApplication.job;

import java.util.List;

public interface JobService {

    List<Job> getAllJobs();
    void CreateJob(Job job);
    Job getJobById(Long id);
    boolean deleteJobById(Long id);
    Job updateJobById(Long id, Job updateJob);
}
