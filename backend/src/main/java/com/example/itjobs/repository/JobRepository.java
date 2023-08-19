package com.example.itjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.itjobs.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
