package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.EmploymentTypeRepository;
import com.example.itjobs.entity.EmploymentType;

@Service
public class EmploymentTypeService {

    private final EmploymentTypeRepository EmploymentTypeRepository;

    @Autowired
    public EmploymentTypeService(EmploymentTypeRepository EmploymentTypeRepository) {
        this.EmploymentTypeRepository = EmploymentTypeRepository;
    }

    public List<EmploymentType> getAllEmploymentTypes() {
        return EmploymentTypeRepository.findAll();
    }

    public Optional<EmploymentType> getEmploymentTypeById(Long id) {
        return EmploymentTypeRepository.findById(id);
    }
}

