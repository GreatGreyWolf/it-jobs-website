package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.ProfessionRepository;
import com.example.itjobs.entity.Profession;

@Service
public class ProfessionService {

    private final ProfessionRepository ProfessionRepository;

    @Autowired
    public ProfessionService(ProfessionRepository ProfessionRepository) {
        this.ProfessionRepository = ProfessionRepository;
    }

    public List<Profession> getAllProfessions() {
        return ProfessionRepository.findAll();
    }

    public Optional<Profession> getProfessionById(Long id) {
        return ProfessionRepository.findById(id);
    }
}

