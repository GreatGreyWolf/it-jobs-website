package com.example.itjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.itjobs.entity.Goodie;

public interface GoodieRepository extends JpaRepository<Goodie, Long> {
}
