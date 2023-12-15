package com.example.demo.converter;

import com.example.demo.DTO.CompetitionDTO;
import com.example.demo.DTO.MemberDTO;
import com.example.demo.DTO.RankingDTO;
import com.example.demo.DTO.RankingDTOResponse;
import com.example.demo.entity.Competition;
import com.example.demo.entity.Member;
import com.example.demo.entity.Ranking;

import java.time.LocalDateTime;

public class RankingConverter {
    public static RankingDTOResponse convertToDTO(Ranking ranking) {
        RankingDTOResponse rankingDTOResponse = new RankingDTOResponse();
        rankingDTOResponse.setMemberRank(ranking.getMemberRank());
        rankingDTOResponse.setScore(ranking.getScore());
        CompetitionDTO competitionDTO=CompetitionConverter.convertToDTO(ranking.getCompetition());
        rankingDTOResponse.setCompetitionDTO(competitionDTO);
        MemberDTO memberDTO=MemberConverter.convertToDTO(ranking.getMember());
        rankingDTOResponse.setMemberDTO(memberDTO);

        return rankingDTOResponse;
    }
}
