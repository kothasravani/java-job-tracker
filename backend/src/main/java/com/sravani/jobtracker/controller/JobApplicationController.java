package com.sravani.jobtracker.controller;

import com.sravani.jobtracker.entity.JobApplication;
import com.sravani.jobtracker.service.JobApplicationService;
import org.springframework.web.bind.annotation.*;

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

}