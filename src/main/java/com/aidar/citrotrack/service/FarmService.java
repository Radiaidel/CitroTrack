package com.aidar.citrotrack.service;

import com.aidar.citrotrack.dto.Farm.FarmDTO;
import com.aidar.citrotrack.dto.Farm.FarmRequestDTO;
import com.aidar.citrotrack.dto.Farm.FarmResponseDTO;
import com.aidar.citrotrack.model.Farm;

import java.time.LocalDate;
import java.util.List;

public interface FarmService {
    FarmDTO createFarm(FarmRequestDTO farmRequestDTO);

    List<FarmResponseDTO> getAllFarms();

    FarmResponseDTO getFarmById(Long id);

    FarmResponseDTO updateFarm(Long id, FarmRequestDTO farmRequestDTO);

    void deleteFarm(Long id);

    List<FarmResponseDTO> searchFarms(String name, String location, Double minArea, Double maxArea, LocalDate creationDateFrom, LocalDate creationDateTo);
}
