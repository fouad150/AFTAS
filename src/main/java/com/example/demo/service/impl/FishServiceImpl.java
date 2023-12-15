package com.example.demo.service.impl;

import com.example.demo.entity.Fish;
import com.example.demo.repository.FishRepository;
import com.example.demo.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FishServiceImpl implements FishService {
    @Autowired
    FishRepository fishRepository;

    @Override
    public Optional<Fish> findById(Long id){
        return fishRepository.findById(id);
    }

}
