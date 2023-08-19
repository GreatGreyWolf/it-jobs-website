package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.RoleRepository;
import com.example.itjobs.entity.Role;

@Service
public class RoleService {

    private final RoleRepository RoleRepository;

    @Autowired
    public RoleService(RoleRepository RoleRepository) {
        this.RoleRepository = RoleRepository;
    }

    public List<Role> getAllRoles() {
        return RoleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return RoleRepository.findById(id);
    }
}

