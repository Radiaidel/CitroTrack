package com.aidar.citrotrack.dto.Tree;

import com.aidar.citrotrack.dto.Field.FieldDTO;
import com.aidar.citrotrack.model.enums.TreeProductivity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TreeDTO {
    private Long id;
    private LocalDate plantingDate;
    private int age ;
    private TreeProductivity productivity;
}
