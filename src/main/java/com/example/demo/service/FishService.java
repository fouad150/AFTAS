package com.example.demo.service;

import com.example.demo.entity.Fish;

import java.util.Optional;

public interface FishService {
    Optional<Fish> findById(Long id);
}
