package com.example.demo.service.impl;

import com.example.demo.DTO.HuntingDTO;
import com.example.demo.entity.*;
import com.example.demo.exception.DateValidationException;
import com.example.demo.exception.DoesNoExistException;
import com.example.demo.exception.FishWeightException;
import com.example.demo.repository.HuntingRepository;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class HuntingServiceImpl implements HuntingService {
    @Autowired
    HuntingRepository huntingRepository;
    @Autowired
    CompetitionService competitionService;
    @Autowired
    MemberService memberService;
    @Autowired
    RankingService rankingService;
    @Autowired
    FishService fishService;

    public Hunting save(HuntingDTO huntingDTO){
        Optional<Competition> competition=competitionService.findById(huntingDTO.getCompetitionId());
        Optional<Member> member=memberService.findById(huntingDTO.getMemberId());
        Optional<Fish> fish=fishService.findById(huntingDTO.getFishId());
        if(competition.isPresent()){
            if(member.isEmpty()){
                throw new DoesNoExistException("this member doesn't exist");
            }else{
                if(fish.isEmpty()){
                    throw new DoesNoExistException("this fish doesn't exist");
                }else{
                    LocalDate competitionDate = competition.get().getDate();
                    LocalTime competitionStartTime=competition.get().getStartTime();
                    LocalDateTime competitionStartDateTime=LocalDateTime.of(competitionDate,competitionStartTime);

                    LocalTime endOfDayTime = LocalTime.of(23, 59, 59);
                    LocalDateTime competitionDayEnd=LocalDateTime.of(competitionDate,endOfDayTime);
                    if(competitionStartDateTime.isAfter(LocalDateTime.now())){
                        throw new DateValidationException("the competition didn't begin yet");
                    }else{
                        if(competitionDayEnd.isAfter(LocalDateTime.now())){
                            throw new DateValidationException("the day of the competition is over ");
                        }else{
                            RankingId rankingId=RankingId.builder()
                                    .competitionId(competition.get().getId())
                                    .memberId(member.get().getId())
                                    .build();
                            Optional<Ranking> ranking=rankingService.findById(rankingId);
                            if(ranking.isEmpty()){
                                throw  new DoesNoExistException("this member doesn't exist in the competition , added first");
                            }else{
                                Optional<Hunting> hunting=huntingRepository.findByCompetitionAndMemberAndFish(competition.get(),member.get(),fish.get());
                                double fishWeight= huntingDTO.getFishWeight();
                                double fishAverageWeight=fish.get().getAverageWeight();
                                if(hunting.isEmpty()){
                                    if(fishWeight>fishAverageWeight || fishWeight ==fishAverageWeight){
                                        Hunting addedHunting=new Hunting(1,competition.get(),fish.get(),member.get());
                                        return huntingRepository.save(addedHunting);
                                    }else{
                                        throw new FishWeightException("the weight of the fish is lower than average ");
                                    }
                                }else{
                                    if(fishWeight>fishAverageWeight || fishWeight ==fishAverageWeight){
                                        Hunting foundHunting=hunting.get();
                                        int currentNumberOfFish =foundHunting.getNumberOfFish();
                                        int newNumberOfFish=currentNumberOfFish+1;
                                        foundHunting.setNumberOfFish(newNumberOfFish);
                                        huntingRepository.save(foundHunting);

                                        Ranking foundRanking=ranking.get();
                                        Integer  currentScore=foundRanking.getScore();
                                        Integer  fishPoints=fish.get().getLevel().getPoints();
                                        Integer  newScore=currentScore+fishPoints;
                                        foundRanking.setScore(newScore);

                                        rankingService.saveValidRanking(foundRanking);
                                    }else{
                                        throw new FishWeightException("the weight of the fish is lower than average ");
                                    }

                                }
                            }
                        }
                    }
                }

            }

        }else{
            throw new DoesNoExistException("this competition doesn't exist");
        }
        return null;
    }
}
