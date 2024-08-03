package com.first.JobApplication.job;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getAllJobs(@PathVariable Long companyId){
        return ResponseEntity.ok(jobService.getAllJobs(companyId));
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> CreateJob(@PathVariable Long companyId, @RequestBody Job job){
        if(jobService.CreateJob(job, companyId)) {
            return new ResponseEntity<>("job added successfully", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Job addition not possible, because company not present", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job!=null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if (deleted) {
            return new ResponseEntity<>("Job deleted Successfully",HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Job not found to be deleted",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<Job> updateJobById(@PathVariable Long id, @RequestBody Job updateJob){
        Job updatedJob = jobService.updateJobById(id, updateJob);
        if (updatedJob!=null){
            return new ResponseEntity<Job>(updatedJob,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
