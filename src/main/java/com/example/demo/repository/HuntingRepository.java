package com.example.demo.repository;

import com.example.demo.entity.Competition;
import com.example.demo.entity.Fish;
import com.example.demo.entity.Hunting;
import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HuntingRepository extends JpaRepository<Hunting, Long> {
    Optional<Hunting> findByCompetitionAndMemberAndFish(Competition competition, Member member, Fish fish);
}
