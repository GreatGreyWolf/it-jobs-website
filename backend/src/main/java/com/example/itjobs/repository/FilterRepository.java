package com.example.itjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.itjobs.entity.Filter;

public interface FilterRepository extends JpaRepository<Filter, Long> {
}
