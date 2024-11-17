package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.Farm.FarmRequestDTO;
import com.aidar.citrotrack.dto.Farm.FarmResponseDTO;
import com.aidar.citrotrack.model.Farm;
import com.aidar.citrotrack.repository.FarmRepository;
import com.aidar.citrotrack.service.FarmService;
import com.aidar.citrotrack.util.FarmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FarmServiceImpl implements FarmService {
    private final FarmRepository farmRepository;
    private final FarmMapper farmMapper;


    @Autowired
    public FarmServiceImpl(FarmRepository farmRepository, FarmMapper farmMapper) {
        this.farmRepository = farmRepository;
        this.farmMapper = farmMapper;
    }

    @Override
    public FarmResponseDTO createFarm(FarmRequestDTO farmRequestDTO) {
        Farm farm = Farm.builder()
                .name(farmRequestDTO.getName())
                .location(farmRequestDTO.getLocation())
                .totalArea(farmRequestDTO.getTotalArea())
                .creationDate(farmRequestDTO.getCreationDate())
                .build();

        farm = farmRepository.save(farm);

        return farmMapper.farmToFarmResponseDTO(farm);
    }

    @Override
    public List<FarmResponseDTO> getAllFarms() {
        return farmRepository.findAll()
                .stream()
                .map(farmMapper::farmToFarmResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FarmResponseDTO getFarmById(Long id) {
        Farm farm = farmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farm not found with ID: " + id));
        return farmMapper.farmToFarmResponseDTO(farm);
    }

    @Override
    public FarmResponseDTO updateFarm(Long id, FarmRequestDTO farmRequestDTO) {
        Farm farm = farmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farm not found with ID: " + id));


        farm = farmMapper.farmRequestDTOToFarm(farmRequestDTO);
        farm.setId(id);
        farm = farmRepository.save(farm);


        return farmMapper.farmToFarmResponseDTO(farm);
    }

    @Override
    public void deleteFarm(Long id) {
        if (!farmRepository.existsById(id)) {
            throw new RuntimeException("Farm not found with ID: " + id);
        }
        farmRepository.deleteById(id);
    }
}
