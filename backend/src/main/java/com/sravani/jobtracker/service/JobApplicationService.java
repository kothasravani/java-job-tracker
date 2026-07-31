package com.sravani.jobtracker.service;

import com.sravani.jobtracker.entity.JobApplication;
import com.sravani.jobtracker.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;
import com.sravani.jobtracker.exception.JobApplicationNotFoundException;

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

    public JobApplication getJobApplicationById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new JobApplicationNotFoundException(id));
    }

    public JobApplication updateJobApplication(Long id, JobApplication updatedJob) {
        JobApplication existingJob = repository.findById(id)
                .orElseThrow(() -> new JobApplicationNotFoundException(id));

        existingJob.setCompanyName(updatedJob.getCompanyName());
        existingJob.setJobTitle(updatedJob.getJobTitle());
        existingJob.setStatus(updatedJob.getStatus());
        existingJob.setApplicationDate(updatedJob.getApplicationDate());

        return repository.save(existingJob);
    }

    public void deleteJobApplication(Long id) {
        JobApplication existingJob = repository.findById(id)
                .orElseThrow(() -> new JobApplicationNotFoundException(id));
        repository.delete(existingJob);
    }
}
