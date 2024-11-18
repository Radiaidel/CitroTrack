package com.aidar.citrotrack.util;

import com.aidar.citrotrack.dto.Tree.TreeRequestDTO;
import com.aidar.citrotrack.dto.Tree.TreeResponseDTO;
import com.aidar.citrotrack.model.HarvestDetailId;
import com.aidar.citrotrack.model.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel =  "spring")
public interface TreeMapper {
    TreeResponseDTO treeToTreeResponseDTO(Tree tree);

    @Mapping(source = "fieldId", target = "field.id")
    Tree treeRequestDTOToTree(TreeRequestDTO treeRequestDTO);

    default Long mapHarvestDetailId(HarvestDetailId harvestDetailId) {
        return harvestDetailId != null ? harvestDetailId.getTreeId() : null;
    }
}
