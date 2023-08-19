package com.example.itjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.itjobs.entity.EmploymentType;

public interface EmploymentTypeRepository extends JpaRepository<EmploymentType, Long> {
}
