package com.example.itjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.itjobs.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
