package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.CompanyRepository;
import com.example.itjobs.entity.Company;
@Service
public class CompanyService {

    private final CompanyRepository CompanyRepository;

    @Autowired
    public CompanyService(CompanyRepository CompanyRepository) {
        this.CompanyRepository = CompanyRepository;
    }

    public boolean existsById(Long id) {
        return CompanyRepository.existsById(id);
    }

    public List<Company> getAllCompanies() {
        return CompanyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return CompanyRepository.findById(id);
    }

    public Company saveCompany(Company Company) {
        return CompanyRepository.save(Company);
    }

    public void deleteCompany(Long id) {
        CompanyRepository.deleteById(id);
    }
}