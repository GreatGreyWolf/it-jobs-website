package com.example.itjobs.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import com.example.itjobs.service.EmploymentTypeService;
import com.example.itjobs.entity.EmploymentType;

@RestController
@RequestMapping("/api/employmentTypes")
public class EmploymentTypeController {

    private final EmploymentTypeService employmentTypeService;

    @Autowired
    public EmploymentTypeController(EmploymentTypeService employmentTypeService) {
        this.employmentTypeService = employmentTypeService;
    }

    @GetMapping
    public List<EmploymentType> getAllEmploymentTypes() {
        return employmentTypeService.getAllEmploymentTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentType> getEmploymentTypeById(@PathVariable Long id) {
        Optional<EmploymentType> employmentType = employmentTypeService.getEmploymentTypeById(id);
        if (employmentType.isPresent()) {
            return ResponseEntity.ok(employmentType.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}