package com.example.itjobs.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import com.example.itjobs.service.MethodCategoryService;
import com.example.itjobs.entity.MethodCategory;

@RestController
@RequestMapping("/api/methodCategories")
public class MethodCategoryController {

    private final MethodCategoryService methodCategoryService;

    @Autowired
    public MethodCategoryController(MethodCategoryService methodCategoryService) {
        this.methodCategoryService = methodCategoryService;
    }

    @GetMapping
    public List<MethodCategory> getAllMethodCategories() {
        return methodCategoryService.getAllMethodCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MethodCategory> getMethodCategoryById(@PathVariable Long id) {
        Optional<MethodCategory> methodCategory = methodCategoryService.getMethodCategoryById(id);
        if (methodCategory.isPresent()) {
            return ResponseEntity.ok(methodCategory.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}