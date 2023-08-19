package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.ExperienceLevelRepository;
import com.example.itjobs.entity.ExperienceLevel;

@Service
public class ExperienceLevelService {

    private final ExperienceLevelRepository ExperienceLevelRepository;

    @Autowired
    public ExperienceLevelService(ExperienceLevelRepository ExperienceLevelRepository) {
        this.ExperienceLevelRepository = ExperienceLevelRepository;
    }

    public List<ExperienceLevel> getAllExperienceLevels() {
        return ExperienceLevelRepository.findAll();
    }

    public Optional<ExperienceLevel> getExperienceLevelById(Long id) {
        return ExperienceLevelRepository.findById(id);
    }
}

