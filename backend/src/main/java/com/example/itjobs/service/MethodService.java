package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.MethodRepository;
import com.example.itjobs.entity.Method;

@Service
public class MethodService {

    private final MethodRepository MethodRepository;

    @Autowired
    public MethodService(MethodRepository MethodRepository) {
        this.MethodRepository = MethodRepository;
    }

    public List<Method> getAllMethods() {
        return MethodRepository.findAll();
    }

    public Optional<Method> getMethodById(Long id) {
        return MethodRepository.findById(id);
    }
}

