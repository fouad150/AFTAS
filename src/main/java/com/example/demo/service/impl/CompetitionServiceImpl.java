package com.example.demo.service.impl;

import com.example.demo.entity.Competition;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.exception.StartAndEndTimeException;
import com.example.demo.repository.CompetitionRepository;
import com.example.demo.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CompetitionServiceImpl implements CompetitionService {
    @Autowired
    CompetitionRepository competitionRepository;
    public Competition saveCompetition(Competition competition){

        if(competitionRepository.existsByCode(competition.getCode())){
            throw new AlreadyExistsException("the code is taken by another competition");
        }
        if(competitionRepository.existsByDateAndLocation(competition.getDate(),competition.getLocation())){
            throw new AlreadyExistsException("the is a competition that have the same location and date");
        }
        System.out.println(competition.getStartTime().isAfter(competition.getEndTime()));
        if(competition.getStartTime().isAfter(competition.getEndTime())){
            throw new StartAndEndTimeException("the start time should be before end time");
        }

        return competitionRepository.save(competition);
    }

    @Override
    public List<Competition> getCompetitions(){

        return competitionRepository.findAll();
    }

    @Override
    public Optional<Competition> findById(Long id){
        return competitionRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id){
        return competitionRepository.existsById(id);
    }


}
