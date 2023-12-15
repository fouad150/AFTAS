package com.example.demo.service;

import com.example.demo.DTO.HuntingDTO;
import com.example.demo.entity.Hunting;

public interface HuntingService {
    Hunting save(HuntingDTO huntingDTO);
}
