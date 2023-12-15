package com.example.demo.entity;

import com.example.demo.enums.IdentityDocumentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero(message = "the number should be positive")
    @NotNull(message="the number should not be null")
    private Integer number;

    @NotNull(message = "First name cannot be null")
    @Size(min = 1, message = "First name must have at least 1 character")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 1, message = "Last name must have at least 1 character")
    private String lastName;

    @NotNull(message = "Accession date cannot be null")
    private LocalDateTime accessionDate;

    @NotNull(message = "Nationality cannot be null")
    @Size(min = 1, message = "Nationality must have at least 1 character")
    private String nationality;

    @NotNull(message = "Identity document cannot be null")
    private IdentityDocumentType identityDocument;

    @NotNull(message = "Identity number cannot be null")
    @Size(min = 1, message = "Identity number must have at least 1 character")
    private String identityNumber;

}
