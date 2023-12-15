package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Ranking {
    @EmbeddedId
    private RankingId id;

    private Integer memberRank;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @MapsId("memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    @MapsId("competitionId")
    private Competition competition;

    public Ranking(Integer memberRank, Member member, Competition competition) {
        this.memberRank=memberRank;
        this.member=member;
        this.competition=competition;
    }
}
