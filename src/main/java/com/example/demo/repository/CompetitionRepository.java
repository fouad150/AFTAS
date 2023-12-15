package com.example.demo.repository;

import com.example.demo.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    boolean existsByCode(String code);
    boolean existsByDateAndLocation(LocalDate date, String location);

     boolean existsById(Long id);
}

