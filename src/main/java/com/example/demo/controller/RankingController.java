package com.example.demo.controller;

import com.example.demo.DTO.CompetitionDTO;
import com.example.demo.DTO.RankingDTO;
import com.example.demo.DTO.RankingDTOResponse;
import com.example.demo.converter.CompetitionConverter;
import com.example.demo.converter.RankingConverter;
import com.example.demo.entity.Competition;
import com.example.demo.entity.Ranking;
import com.example.demo.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    @PostMapping("/rankings")
    public ResponseEntity<?> saveRanking(@RequestBody RankingDTO rankingDTO) {
        Ranking addedRanking = rankingService.save(rankingDTO);
        RankingDTOResponse addedRankingDTO = RankingConverter.convertToDTO(addedRanking);
        return new ResponseEntity<>(addedRankingDTO, HttpStatus.OK);
    }


}
