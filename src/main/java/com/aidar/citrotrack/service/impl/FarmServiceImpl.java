package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.Farm.FarmDTO;
import com.aidar.citrotrack.dto.Farm.FarmRequestDTO;
import com.aidar.citrotrack.dto.Farm.FarmResponseDTO;
import com.aidar.citrotrack.model.Farm;
import com.aidar.citrotrack.repository.FarmRepository;
import com.aidar.citrotrack.service.FarmService;
import com.aidar.citrotrack.mapper.FarmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public FarmDTO createFarm(FarmRequestDTO farmRequestDTO) {
        Farm farm = Farm.builder()
                .name(farmRequestDTO.getName())
                .location(farmRequestDTO.getLocation())
                .totalArea(farmRequestDTO.getTotalArea())
                .creationDate(farmRequestDTO.getCreationDate())
                .build();

        farm = farmRepository.save(farm);

        return farmMapper.farmToFarmDTO(farm);
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

//    @Override
//    public FarmResponseDTO updateFarm(Long id, FarmRequestDTO farmRequestDTO) {
//        Farm farm = farmRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Farm not found with ID: " + id));
//
//
//        farm = farmMapper.farmRequestDTOToFarm(farmRequestDTO);
//        farm.setId(id);
//        farm = farmRepository.save(farm);
//
////        Farm updatedFarm = farmRepository.save(farmMapper.farmRequestDTOToFarm(farmRequestDTO));
//
//
//        return farmMapper.farmToFarmResponseDTO(farm);
//    }

    @Override
    public FarmDTO updateFarm(Long id, FarmRequestDTO farmRequestDTO) {
        Farm existingFarm;
        farmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farm not found with ID: " + id));

//        farmMapper.updateFarmFromDTO(farmRequestDTO, existingFarm);
        existingFarm = farmMapper.farmRequestDTOToFarm(farmRequestDTO);
        Farm savedFarm = farmRepository.save(existingFarm);

        return farmMapper.farmToFarmDTO(savedFarm);
    }

    @Override
    public void deleteFarm(Long id) {
        if (!farmRepository.existsById(id)) {
            throw new RuntimeException("Farm not found with ID: " + id);
        }
        farmRepository.deleteById(id);
    }

    @Override
    public List<FarmResponseDTO> searchFarms(String name, String location, Double minArea, Double maxArea, LocalDate creationDateFrom, LocalDate creationDateTo) {
        Map<String, Object> criteria = new HashMap<>();
        if (name != null && !name.isEmpty()) criteria.put("name", name);
        if (location != null && !location.isEmpty()) criteria.put("location", location);
        if (minArea != null) criteria.put("minArea", minArea);
        if (maxArea != null) criteria.put("maxArea", maxArea);
        if (creationDateFrom != null) criteria.put("creationDateFrom", creationDateFrom);
        if (creationDateTo != null) criteria.put("creationDateTo", creationDateTo);


        return farmRepository.searchFarms(criteria).stream().map(farmMapper::farmToFarmResponseDTO).collect(Collectors.toList());
    }
}
