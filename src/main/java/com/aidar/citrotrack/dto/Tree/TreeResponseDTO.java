package com.aidar.citrotrack.dto.Tree;


import com.aidar.citrotrack.dto.Field.FieldDTO;
import com.aidar.citrotrack.dto.Field.FieldResponseDTO;
import com.aidar.citrotrack.dto.HarvestDetail.EmbeddableHarvestDetailDTO;
import com.aidar.citrotrack.model.HarvestDetail;
import com.aidar.citrotrack.model.enums.TreeProductivity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TreeResponseDTO {

    private Long id;
    private LocalDate plantingDate;
    private int age ;
    private FieldDTO field;
    private TreeProductivity productivity;
    private List<EmbeddableHarvestDetailDTO> harvestDetails;

}
