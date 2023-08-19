package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.CertificateRepository;
import com.example.itjobs.entity.Certificate;

@Service
public class CertificateService {

    private final CertificateRepository CertificateRepository;

    @Autowired
    public CertificateService(CertificateRepository CertificateRepository) {
        this.CertificateRepository = CertificateRepository;
    }

    public List<Certificate> getAllCertificates() {
        return CertificateRepository.findAll();
    }

    public Optional<Certificate> getCertificateById(Long id) {
        return CertificateRepository.findById(id);
    }
}

