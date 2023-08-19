package com.example.itjobs.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import com.example.itjobs.service.JobRequirementService;
import com.example.itjobs.entity.JobRequirement;

@RestController
@RequestMapping("/api/jobRequirements")
public class JobRequirementController {

    private final JobRequirementService jobRequirementService;

    @Autowired
    public JobRequirementController(JobRequirementService jobRequirementService) {
        this.jobRequirementService = jobRequirementService;
    }

    @GetMapping
    public List<JobRequirement> getAllJobRequirements() {
        return jobRequirementService.getAllJobRequirements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobRequirement> getJobRequirementById(@PathVariable Long id) {
        Optional<JobRequirement> jobRequirement = jobRequirementService.getJobRequirementById(id);
        if (jobRequirement.isPresent()) {
            return ResponseEntity.ok(jobRequirement.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<JobRequirement> createJobRequirement(@Valid @RequestBody JobRequirement jobRequirement) {
        JobRequirement createdJobRequirement = jobRequirementService.saveJobRequirement(jobRequirement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJobRequirement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobRequirement> updateJobRequirement(@PathVariable Long id, @Valid @RequestBody JobRequirement updatedJobRequirement) {
        if (!jobRequirementService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedJobRequirement.setId(id);
        JobRequirement savedJobRequirement = jobRequirementService.saveJobRequirement(updatedJobRequirement);
        return ResponseEntity.ok(savedJobRequirement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobRequirement(@PathVariable Long id) {
        if (!jobRequirementService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jobRequirementService.deleteJobRequirement(id);
        return ResponseEntity.noContent().build();
    }
}