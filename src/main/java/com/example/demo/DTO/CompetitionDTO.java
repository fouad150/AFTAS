package com.example.demo.DTO;

import com.example.demo.enums.IdentityDocumentType;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class CompetitionDTO {
    @NotNull(message="the code should not be null")
    @NotBlank(message="the code should not be blank")
    private String code;

    @NotNull(message = "date cannot be null")
    private LocalDate date;

    @NotNull(message = "start time should not be null")
    private LocalTime startTime;

    @NotNull(message = "end time should not be null")
    private LocalTime endTime;

    @NotNull(message = "the number of participants cannot be null")
    @PositiveOrZero(message="the number of participants cannot be negative")
    private Integer numberOfParticipants;

    @NotNull(message = "location cannot be null")
    @Size(min = 1, message = "location must have at least 1 character")
    private String location;

    @NotNull(message = "the amount cannot be null")
    @PositiveOrZero(message="the amount cannot be negative")
    private Double amount;

    private String Status;
}
