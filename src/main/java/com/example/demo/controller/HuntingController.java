package com.example.demo.controller;

import com.example.demo.DTO.HuntingDTO;
import com.example.demo.entity.Hunting;
import com.example.demo.service.HuntingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class HuntingController {
    @Autowired
    HuntingService huntingService;
    @PostMapping("/huntings")
    public ResponseEntity<?> saveRanking(@RequestBody HuntingDTO huntingDTO) {
      Hunting hunting= huntingService.save(huntingDTO);
      return new ResponseEntity<>(hunting, HttpStatus.OK);
    }

}
