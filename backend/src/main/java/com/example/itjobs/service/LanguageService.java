package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.LanguageRepository;
import com.example.itjobs.entity.Language;

@Service
public class LanguageService {

    private final LanguageRepository LanguageRepository;

    @Autowired
    public LanguageService(LanguageRepository LanguageRepository) {
        this.LanguageRepository = LanguageRepository;
    }

    public List<Language> getAllLanguages() {
        return LanguageRepository.findAll();
    }

    public Optional<Language> getLanguageById(Long id) {
        return LanguageRepository.findById(id);
    }
}

