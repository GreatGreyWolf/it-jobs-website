package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.JobRepository;
import com.example.itjobs.entity.Job;

@Service
public class JobService {

    private final JobRepository JobRepository;

    @Autowired
    public JobService(JobRepository JobRepository) {
        this.JobRepository = JobRepository;
    }

    public boolean existsById(Long id) {
        return JobRepository.existsById(id);
    }

    public List<Job> getAllJobs() {
        return JobRepository.findAll();
    }

    public List<Job> findAll(Specification<Job> specification) {
        return JobRepository.findAll(specification);
    }

    public Optional<Job> getJobById(Long id) {
        return JobRepository.findById(id);
    }

    public Job saveJob(Job job) {
        validateJob(job);
        return JobRepository.save(job);
    }

    private void validateJob(Job job) {
        if (job.getSalaryMin() > job.getSalaryMax()) {
            throw new IllegalArgumentException("Salary minimum cannot be greater than salary maximum");
        }

        if (job.getWorkPercentageMin() > job.getWorkPercentageMax()) {
            throw new IllegalArgumentException("Work percentage minimum cannot be greater than work percentage maximum");
        }
    }

    public void deleteJob(Long id) {
        JobRepository.deleteById(id);
    }
}