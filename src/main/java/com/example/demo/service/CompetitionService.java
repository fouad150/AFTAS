package com.example.demo.service;

import com.example.demo.entity.Competition;

import java.util.List;
import java.util.Optional;

public interface CompetitionService {
    Competition saveCompetition(Competition competition);
    List<Competition> getCompetitions();
    Optional<Competition> findById(Long id);
    boolean existsById(Long id);
}
