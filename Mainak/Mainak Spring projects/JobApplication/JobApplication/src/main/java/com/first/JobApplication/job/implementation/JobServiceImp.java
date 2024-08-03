package com.first.JobApplication.job.implementation;

import com.first.JobApplication.company.Company;
import com.first.JobApplication.company.CompanyService;
import com.first.JobApplication.job.Job;
import com.first.JobApplication.job.JobRepository;
import com.first.JobApplication.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImp implements JobService {

    //public List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;
    CompanyService companyService;
    //private long nextId = 1L;

    public JobServiceImp(JobRepository jobRepository, CompanyService companyService) {
        this.jobRepository = jobRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Job> getAllJobs(Long companyId) {
        return jobRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean CreateJob(Job job, Long companyId) {
        //job.setId(nextId++);
        Company company = companyService.getCompaniesById(companyId);
        if(null != company){
            job.setCompany(company);
            jobRepository.save(job);
            return true;
        }
        return false;
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        Job job = getJobById(id);
        if(null != job){
            jobRepository.delete(job);
            return true;
        }
        return false;
    }

    @Override
    public Job updateJobById(Long id, Job updateJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
            if(jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setDescription(updateJob.getDescription());
                job.setLocation(updateJob.getLocation());
                job.setTitle(updateJob.getTitle());
                job.setMaxSalary(updateJob.getMaxSalary());
                job.setMinSalary(updateJob.getMinSalary());

                jobRepository.save(job);

                return job;
            }

        return null;
    }

}
