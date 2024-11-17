package com.aidar.citrotrack.service;

import com.aidar.citrotrack.dto.Farm.FarmRequestDTO;
import com.aidar.citrotrack.dto.Farm.FarmResponseDTO;

import java.util.List;

public interface FarmService {
    FarmResponseDTO createFarm(FarmRequestDTO farmRequestDTO);

    List<FarmResponseDTO> getAllFarms();

    FarmResponseDTO getFarmById(Long id);

    FarmResponseDTO updateFarm(Long id, FarmRequestDTO farmRequestDTO);

    void deleteFarm(Long id);
}
