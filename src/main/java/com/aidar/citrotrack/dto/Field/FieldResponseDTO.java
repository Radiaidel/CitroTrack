package com.aidar.citrotrack.dto.Field;

import com.aidar.citrotrack.dto.Farm.FarmDTO;
import com.aidar.citrotrack.dto.Harvest.HarvestDTO;
import com.aidar.citrotrack.dto.Tree.TreeDTO;
import com.aidar.citrotrack.dto.Tree.TreeResponseDTO;
import com.aidar.citrotrack.model.Harvest;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldResponseDTO {
    private Long id;
    private Double area;
    private FarmDTO farm;
    private List<TreeDTO> trees;
    private List<HarvestDTO> harvests;

}