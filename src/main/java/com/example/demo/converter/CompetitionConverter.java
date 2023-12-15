package com.example.demo.converter;

import com.example.demo.DTO.CompetitionDTO;
import com.example.demo.entity.Competition;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CompetitionConverter {
    public static Competition convertToEntity(CompetitionDTO competitionDTO) {
        Competition competition = new Competition();
        competition.setAmount(competitionDTO.getAmount());
        competition.setDate(competitionDTO.getDate());
        competition.setCode(competitionDTO.getCode());
        competition.setLocation(competitionDTO.getLocation());
        competition.setNumberOfParticipants(competitionDTO.getNumberOfParticipants());
        competition.setStartTime(competitionDTO.getStartTime());
        competition.setEndTime(competitionDTO.getEndTime());
        competition.setStatus("available");

        return competition;
    }

    public static CompetitionDTO convertToDTO(Competition competition) {
        CompetitionDTO competitionDTO = new CompetitionDTO();
        competitionDTO.setAmount(competition.getAmount());
        competitionDTO.setDate(competition.getDate());
        competitionDTO.setCode(competition.getCode());
        competitionDTO.setLocation(competition.getLocation());
        competitionDTO.setNumberOfParticipants(competition.getNumberOfParticipants());
        competitionDTO.setStartTime(competition.getStartTime());
        competitionDTO.setEndTime(competition.getEndTime());
        LocalDateTime dateTime=competition.getDate().atStartOfDay();
        LocalDateTime currentDateTime=LocalDateTime.now();
        if(dateTime.isBefore(currentDateTime)){
            competitionDTO.setStatus("closed");
        }else{
            competitionDTO.setStatus("available");
        }

        return competitionDTO;
    }

    public static List<CompetitionDTO> convertToDTOList(List<Competition> competitions) {
        return competitions.stream()
                .map(competition -> CompetitionConverter.convertToDTO(competition))
                .collect(Collectors.toList());
    }
}
