package com.aidar.citrotrack.dto.Farm;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmDTO {
    private Long id;

    private String name;

    private String location;

    private Double totalArea;

    private LocalDate creationDate;
}
