package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.MethodCategoryRepository;
import com.example.itjobs.entity.MethodCategory;

@Service
public class MethodCategoryService {

    private final MethodCategoryRepository MethodCategoryRepository;

    @Autowired
    public MethodCategoryService(MethodCategoryRepository MethodCategoryRepository) {
        this.MethodCategoryRepository = MethodCategoryRepository;
    }

    public List<MethodCategory> getAllMethodCategories() {
        return MethodCategoryRepository.findAll();
    }

    public Optional<MethodCategory> getMethodCategoryById(Long id) {
        return MethodCategoryRepository.findById(id);
    }
}

