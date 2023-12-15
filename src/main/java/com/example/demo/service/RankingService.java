package com.example.demo.service;

import com.example.demo.DTO.RankingDTO;
import com.example.demo.entity.Member;
import com.example.demo.entity.Ranking;
import com.example.demo.entity.RankingId;

import java.util.Optional;

public interface RankingService {
    Ranking save(RankingDTO rankingDTO);
    Optional<Ranking> findById(RankingId rankingId);

    public Ranking saveValidRanking(Ranking ranking);
}
