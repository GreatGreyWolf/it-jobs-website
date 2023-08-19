package com.example.itjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.itjobs.entity.Profession;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
