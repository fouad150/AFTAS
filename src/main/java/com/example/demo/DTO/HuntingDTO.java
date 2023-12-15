package com.example.demo.DTO;

import com.example.demo.entity.Competition;
import com.example.demo.entity.Fish;
import com.example.demo.entity.Member;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class HuntingDTO {
   /* @NotNull(message="the number of fish should not be null")
    private Integer numberOfFish;*/

    @ManyToOne
    @NotNull(message="the competition Object should not be null")
    private Long competitionId;

    @ManyToOne
    @NotNull(message="the fish Object should not be null")
    private Long fishId;

    @ManyToOne
    private Long memberId;

    private double fishWeight;
}
