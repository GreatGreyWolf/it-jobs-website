package com.example.itjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.itjobs.entity.Method;

public interface MethodRepository extends JpaRepository<Method, Long> {
}
