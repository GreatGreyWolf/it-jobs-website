package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.JobRequirementRepository;
import com.example.itjobs.entity.JobRequirement;

@Service
public class JobRequirementService {

    private final JobRequirementRepository JobRequirementRepository;

    @Autowired
    public JobRequirementService(JobRequirementRepository JobRequirementRepository) {
        this.JobRequirementRepository = JobRequirementRepository;
    }

    public boolean existsById(Long id) {
        return JobRequirementRepository.existsById(id);
    }

    public List<JobRequirement> getAllJobRequirements() {
        return JobRequirementRepository.findAll();
    }

    public Optional<JobRequirement> getJobRequirementById(Long id) {
        return JobRequirementRepository.findById(id);
    }

    public JobRequirement saveJobRequirement(JobRequirement JobRequirement) {
        return JobRequirementRepository.save(JobRequirement);
    }

    public void deleteJobRequirement(Long id) {
        JobRequirementRepository.deleteById(id);
    }
}