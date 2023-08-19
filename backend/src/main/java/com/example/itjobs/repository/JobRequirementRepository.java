package com.example.itjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.itjobs.entity.JobRequirement;

public interface JobRequirementRepository extends JpaRepository<JobRequirement, Long> {
}
