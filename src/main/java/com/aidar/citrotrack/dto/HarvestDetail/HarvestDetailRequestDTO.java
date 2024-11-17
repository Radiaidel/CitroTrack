package com.aidar.citrotrack.dto.HarvestDetail;

public record HarvestDetailRequestDTO(

         Double quantity,
         Long harvestId,
         Long treeId
) {
}
