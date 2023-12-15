package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Hunting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numberOfFish;

    @ManyToOne
    private Competition competition;

    @ManyToOne
    private Fish fish;

    @ManyToOne
    private Member member;

    public Hunting(Integer numberOfFish, Competition competition, Fish fish, Member member) {
        this.numberOfFish = numberOfFish;
        this.competition = competition;
        this.fish = fish;
        this.member = member;
    }
}
