package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.TechnologyRepository;
import com.example.itjobs.entity.Technology;

@Service
public class TechnologyService {

    private final TechnologyRepository TechnologyRepository;

    @Autowired
    public TechnologyService(TechnologyRepository TechnologyRepository) {
        this.TechnologyRepository = TechnologyRepository;
    }

    public List<Technology> getAllTechnologies() {
        return TechnologyRepository.findAll();
    }

    public Optional<Technology> getTechnologyById(Long id) {
        return TechnologyRepository.findById(id);
    }
}

