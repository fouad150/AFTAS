package com.example.demo.repository;

import com.example.demo.entity.Competition;
import com.example.demo.entity.Member;
import com.example.demo.entity.Ranking;
import com.example.demo.entity.RankingId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
    boolean existsByCompetition(Competition competition);
    boolean existsByMember( Member addedMember);
    boolean existsByCompetitionAndMember(Competition competition,Member member);

    Optional<Ranking>  findById(RankingId rankingId);
}
