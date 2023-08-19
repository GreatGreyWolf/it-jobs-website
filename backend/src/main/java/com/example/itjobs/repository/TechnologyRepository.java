package com.example.itjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.itjobs.entity.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}
