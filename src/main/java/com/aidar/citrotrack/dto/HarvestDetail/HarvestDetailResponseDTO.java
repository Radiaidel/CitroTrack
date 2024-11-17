package com.aidar.citrotrack.dto.HarvestDetail;

import com.aidar.citrotrack.dto.Harvest.HarvestDTO;
import com.aidar.citrotrack.dto.Harvest.HarvestResponseDTO;
import com.aidar.citrotrack.dto.Tree.TreeDTO;
import com.aidar.citrotrack.dto.Tree.TreeResponseDTO;
import lombok.*;


public record HarvestDetailResponseDTO(
        Long id,
         Double quantity,
         TreeDTO tree,
         HarvestDTO harvest
){


}