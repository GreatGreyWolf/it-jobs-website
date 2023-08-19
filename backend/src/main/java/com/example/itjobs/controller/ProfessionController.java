package com.example.itjobs.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import com.example.itjobs.service.ProfessionService;
import com.example.itjobs.entity.Profession;

@RestController
@RequestMapping("/api/professions")
public class ProfessionController {

    private final ProfessionService professionService;

    @Autowired
    public ProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @GetMapping
    public List<Profession> getAllProfessions() {
        return professionService.getAllProfessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profession> getProfessionById(@PathVariable Long id) {
        Optional<Profession> profession = professionService.getProfessionById(id);
        if (profession.isPresent()) {
            return ResponseEntity.ok(profession.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}