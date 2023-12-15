package com.example.demo.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class RankingDTOResponse {

    private Integer memberRank;

    private double score;

    private MemberDTO memberDTO;

    private CompetitionDTO competitionDTO;
}
