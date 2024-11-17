package com.aidar.citrotrack.dto.Farm;


import com.aidar.citrotrack.dto.Field.FieldDTO;
import com.aidar.citrotrack.dto.Field.FieldResponseDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmResponseDTO {

    private Long id;

    private String name;

    private String location;

    private Double totalArea;

    private LocalDate creationDate;

    private List<FieldDTO> fields;
}
