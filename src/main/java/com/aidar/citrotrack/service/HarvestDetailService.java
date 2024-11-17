package com.aidar.citrotrack.service;

import com.aidar.citrotrack.dto.HarvestDetail.HarvestDetailRequestDTO;
import com.aidar.citrotrack.dto.HarvestDetail.HarvestDetailResponseDTO;

import java.util.List;

public interface HarvestDetailService {
    HarvestDetailResponseDTO createHarvestDetail(HarvestDetailRequestDTO harvestDetailRequestDTO);
    HarvestDetailResponseDTO getHarvestDetail(Long harvestId, Long treeId);
    List<HarvestDetailResponseDTO> getHarvestDetailsByHarvest(Long harvestId);
    HarvestDetailResponseDTO updateHarvestDetail(Long harvestId, Long treeId, HarvestDetailRequestDTO harvestDetailRequestDTO);
    void deleteHarvestDetail(Long harvestId, Long treeId);
}
