package com.example.itjobs.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import com.example.itjobs.service.MethodService;
import com.example.itjobs.entity.Method;

@RestController
@RequestMapping("/api/methods")
public class MethodController {

    private final MethodService methodService;

    @Autowired
    public MethodController(MethodService methodService) {
        this.methodService = methodService;
    }

    @GetMapping
    public List<Method> getAllMethods() {
        return methodService.getAllMethods();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Method> getMethodById(@PathVariable Long id) {
        Optional<Method> method = methodService.getMethodById(id);
        if (method.isPresent()) {
            return ResponseEntity.ok(method.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}