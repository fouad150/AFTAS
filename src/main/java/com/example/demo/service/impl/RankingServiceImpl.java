package com.example.demo.service.impl;

import com.example.demo.DTO.MemberDTO;
import com.example.demo.DTO.RankingDTO;
import com.example.demo.converter.MemberConverter;
import com.example.demo.entity.Competition;
import com.example.demo.entity.Member;
import com.example.demo.entity.Ranking;
import com.example.demo.entity.RankingId;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.exception.DateValidationException;
import com.example.demo.exception.DoesNoExistException;
import com.example.demo.repository.RankingRepository;
import com.example.demo.service.CompetitionService;
import com.example.demo.service.MemberService;
import com.example.demo.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class RankingServiceImpl implements RankingService {
    @Autowired
    RankingRepository rankingRepository;
    @Autowired
    CompetitionService competitionService;
    @Autowired
    MemberService memberService;

    @Override
    public Ranking save(RankingDTO rankingDTO){
        Optional<Competition> competitionOptional=competitionService.findById(rankingDTO.getCompetitionId());
        if(competitionOptional.isEmpty()){
            throw new DoesNoExistException("this competition doesn't exist");
        }else{
            Competition competition=competitionOptional.get();
            LocalDate competitionDate=competition.getDate();
            LocalTime competitionStartTime=competition.getStartTime();
            LocalDateTime competitionDateTime=LocalDateTime.of(competitionDate,competitionStartTime);
            LocalDateTime currentDateTime = LocalDateTime.now();

            if(currentDateTime.isBefore(competitionDateTime)){
                MemberDTO memberDTO=rankingDTO.getMemberDTO();
                Member member= MemberConverter.convertToEntity(memberDTO);
                if(memberService.isExistsByNumber(memberDTO.getNumber())){
                    Member foundMember =memberService.findByNumber(memberDTO.getNumber());
                    if(rankingRepository.existsByCompetitionAndMember(competition,foundMember)){
                        throw new AlreadyExistsException("the member already added to this competition");
                    }else{
                        Ranking ranking= Ranking.builder()
                                .id(
                                        RankingId.builder()
                                                .competitionId(competition.getId())
                                                .memberId(foundMember.getId())
                                                .build()
                                )
                                .competition(competition)
                                .member(foundMember)
                                .memberRank(0)
                                .score(0)
                                .build();
                        return rankingRepository.save(ranking);
                    }

                }else{
                    Member addedMember=memberService.save(member);
                    Ranking ranking= Ranking.builder()
                            .id(
                                    RankingId.builder()
                                            .competitionId(competition.getId())
                                            .memberId(addedMember.getId())
                                            .build()
                            )
                            .competition(competition)
                            .member(addedMember)
                            .memberRank(0)
                            .score(0)
                            .build();
                    return rankingRepository.save(ranking);
                }
            }else{
                throw new DateValidationException("the competition is closed");
            }

        }
    }

    @Override
    public Optional<Ranking> findById(RankingId rankingId){
        return rankingRepository.findById(rankingId);
    };

    @Override
    public Ranking saveValidRanking(Ranking ranking){
        return rankingRepository.save(ranking);
    }

}
