package com.example.itjobs.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import com.example.itjobs.service.FilterService;
import com.example.itjobs.entity.Filter;

@RestController
@RequestMapping("/api/filters")
public class FilterController {

    private final FilterService filterService;

    @Autowired
    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }

    @GetMapping
    public List<Filter> getAllFilters() {
        return filterService.getAllFilters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filter> getFilterById(@PathVariable Long id) {
        Optional<Filter> filter = filterService.getFilterById(id);
        if (filter.isPresent()) {
            return ResponseEntity.ok(filter.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Filter> createFilter(@Valid @RequestBody Filter filter) {
        Filter createdFilter = filterService.saveFilter(filter);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFilter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filter> updateFilter(@PathVariable Long id, @Valid @RequestBody Filter updatedFilter) {
        if (!filterService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedFilter.setId(id);
        Filter savedFilter = filterService.saveFilter(updatedFilter);
        return ResponseEntity.ok(savedFilter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilter(@PathVariable Long id) {
        if (!filterService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        filterService.deleteFilter(id);
        return ResponseEntity.noContent().build();
    }
}