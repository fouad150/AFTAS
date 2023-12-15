package com.example.demo.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class RankingDTO {

/*
    @PositiveOrZero(message = "the rank should be positive")
    @NotNull(message="the rank should not be null")
    private Integer memberRank;
*/

    /*@PositiveOrZero(message = "the rank should be positive")
    @NotNull(message="the score should not be null")
    private Integer score;*/

    @NotNull(message="the member object should not be null")
    private MemberDTO memberDTO;

    @NotNull(message="the competition id should not be null")
    private Long competitionId;
}
