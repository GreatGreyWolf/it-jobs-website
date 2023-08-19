package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

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

    public Optional<Job> getJobById(Long id) {
        return JobRepository.findById(id);
    }

    public Job saveJob(Job Job) {
        return JobRepository.save(Job);
    }

    public void deleteJob(Long id) {
        JobRepository.deleteById(id);
    }
}