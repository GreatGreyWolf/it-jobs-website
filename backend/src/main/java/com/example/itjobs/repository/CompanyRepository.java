package com.example.itjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.itjobs.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
