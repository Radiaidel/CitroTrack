package com.aidar.citrotrack.dto.HarvestDetail;

import com.aidar.citrotrack.dto.Harvest.HarvestDTO;
import com.aidar.citrotrack.dto.Harvest.HarvestResponseDTO;
import com.aidar.citrotrack.dto.Tree.TreeDTO;
import com.aidar.citrotrack.dto.Tree.TreeResponseDTO;
import com.aidar.citrotrack.model.HarvestDetailId;
import lombok.*;


public record HarvestDetailResponseDTO(
        HarvestDetailId id,
         Double quantity,
         TreeDTO tree,
         HarvestDTO harvest
){


}