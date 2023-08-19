package com.example.itjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.itjobs.entity.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
