package com.sravani.jobtracker.service;

import com.sravani.jobtracker.entity.JobApplication;
import com.sravani.jobtracker.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public JobApplication createJobApplication(JobApplication jobApplication) {
        return repository.save(jobApplication);
    }

    public List<JobApplication> getAllJobApplications() {
        return repository.findAll();
    }
}
