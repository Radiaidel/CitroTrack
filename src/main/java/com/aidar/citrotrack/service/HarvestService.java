package com.aidar.citrotrack.service;

import com.aidar.citrotrack.dto.Harvest.HarvestRequestDTO;
import com.aidar.citrotrack.dto.Harvest.HarvestResponseDTO;

import java.util.List;

public interface HarvestService {
    HarvestResponseDTO createHarvest(HarvestRequestDTO harvestRequestDTO);

    HarvestResponseDTO updateHarvest(Long id, HarvestRequestDTO harvestRequestDTO);

    void deleteHarvest(Long id);

    HarvestResponseDTO getHarvestById(Long id);

    List<HarvestResponseDTO> getAllHarvests();
}
