package com.example.itjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.itjobs.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
