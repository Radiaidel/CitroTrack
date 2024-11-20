package com.aidar.citrotrack.mapper;

import com.aidar.citrotrack.dto.HarvestDetail.HarvestDetailRequestDTO;
import com.aidar.citrotrack.dto.HarvestDetail.HarvestDetailResponseDTO;
import com.aidar.citrotrack.model.HarvestDetail;
import com.aidar.citrotrack.model.HarvestDetailId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface HarvestDetailMapper {
    @Mapping(source = "harvestId", target = "id.harvestId")
    @Mapping(source = "treeId", target = "id.treeId")
    HarvestDetail harvestDetailRequestDTOToHarvestDetail(HarvestDetailRequestDTO harvestDetailRequestDTO);


    @Mappings({
            @Mapping(source = "id.harvestId", target = "harvest.id"),
            @Mapping(source = "id.treeId", target = "tree.id"),
    })
    HarvestDetailResponseDTO harvestDetailToHarvestDetailResponseDTO(HarvestDetail harvestDetail);

}