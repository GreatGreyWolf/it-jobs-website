package com.example.itjobs.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import com.example.itjobs.service.ExperienceLevelService;
import com.example.itjobs.entity.ExperienceLevel;

@RestController
@RequestMapping("/api/experienceLevels")
public class ExperienceLevelController {

    private final ExperienceLevelService experienceLevelService;

    @Autowired
    public ExperienceLevelController(ExperienceLevelService experienceLevelService) {
        this.experienceLevelService = experienceLevelService;
    }

    @GetMapping
    public List<ExperienceLevel> getAllExperienceLevels() {
        return experienceLevelService.getAllExperienceLevels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceLevel> getExperienceLevelById(@PathVariable Long id) {
        Optional<ExperienceLevel> experienceLevel = experienceLevelService.getExperienceLevelById(id);
        if (experienceLevel.isPresent()) {
            return ResponseEntity.ok(experienceLevel.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}