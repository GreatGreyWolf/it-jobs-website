package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.FilterRepository;
import com.example.itjobs.entity.Filter;

@Service
public class FilterService {

    private final FilterRepository FilterRepository;

    @Autowired
    public FilterService(FilterRepository FilterRepository) {
        this.FilterRepository = FilterRepository;
    }

    public boolean existsById(Long id) {
        return FilterRepository.existsById(id);
    }

    public List<Filter> getAllFilters() {
        return FilterRepository.findAll();
    }

    public Optional<Filter> getFilterById(Long id) {
        return FilterRepository.findById(id);
    }

    public Filter saveFilter(Filter Filter) {
        return FilterRepository.save(Filter);
    }

    public void deleteFilter(Long id) {
        FilterRepository.deleteById(id);
    }
}