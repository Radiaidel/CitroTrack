package com.aidar.citrotrack.mapper;

import com.aidar.citrotrack.dto.Tree.TreeRequestDTO;
import com.aidar.citrotrack.dto.Tree.TreeResponseDTO;
import com.aidar.citrotrack.model.HarvestDetailId;
import com.aidar.citrotrack.model.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel =  "spring")
public interface TreeMapper {
    TreeResponseDTO toResponse(Tree tree);

    @Mapping(source = "fieldId", target = "field.id")
    Tree toEntity(TreeRequestDTO treeRequestDTO);

    default Long mapHarvestDetailId(HarvestDetailId harvestDetailId) {
        return harvestDetailId != null ? harvestDetailId.getTreeId() : null;
    }
}
