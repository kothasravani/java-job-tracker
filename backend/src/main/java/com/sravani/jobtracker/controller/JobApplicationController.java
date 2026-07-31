package com.sravani.jobtracker.controller;

import com.sravani.jobtracker.entity.JobApplication;
import com.sravani.jobtracker.service.JobApplicationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public JobApplication createJobApplication(@RequestBody JobApplication jobApplication) {
        return service.createJobApplication(jobApplication);
    }

    @GetMapping
    public List<JobApplication> getAllJobApplications() {
        return service.getAllJobApplications();
    }

    @GetMapping("/{id}")
    public JobApplication getJobApplicationById(@PathVariable Long id) {
        return service.getJobApplicationById(id);
    }

    @PutMapping("/{id}")
    public JobApplication updateJobApplication(
            @PathVariable Long id,
            @RequestBody JobApplication updatedJob) {

        return service.updateJobApplication(id, updatedJob);
    }

    @DeleteMapping("/{id}")
    public void deleteJobApplication(@PathVariable Long id) {
        service.deleteJobApplication(id);
    }

}