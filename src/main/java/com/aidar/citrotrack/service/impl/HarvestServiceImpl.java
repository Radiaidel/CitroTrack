package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.Harvest.HarvestRequestDTO;
import com.aidar.citrotrack.dto.Harvest.HarvestResponseDTO;
import com.aidar.citrotrack.model.Field;
import com.aidar.citrotrack.model.Harvest;
import com.aidar.citrotrack.model.enums.Seasons;
import com.aidar.citrotrack.repository.FieldRepository;
import com.aidar.citrotrack.repository.HarvestRepository;
import com.aidar.citrotrack.service.HarvestService;
import com.aidar.citrotrack.util.HarvestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HarvestServiceImpl implements HarvestService {
    private final HarvestRepository harvestRepository;
    private final FieldRepository fieldRepository;
    private final HarvestMapper harvestMapper;

    @Autowired
    public HarvestServiceImpl(HarvestRepository harvestRepository, HarvestMapper harvestMapper, FieldRepository fieldRepository) {
        this.harvestRepository = harvestRepository;
        this.harvestMapper = harvestMapper;
        this.fieldRepository = fieldRepository;
    }

    @Override
    public HarvestResponseDTO createHarvest(HarvestRequestDTO harvestRequestDTO) {
        LocalDate harvestDate = harvestRequestDTO.getHarvestDate();
        Seasons season = Seasons.fromDate(harvestDate);


        Field field = fieldRepository.findById(harvestRequestDTO.getFieldId())
                .orElseThrow(() -> new RuntimeException("Field not found with id: " + harvestRequestDTO.getFieldId()));

        Harvest harvest = Harvest.builder().harvestDate(harvestDate).field(field).season(season).build();


        harvestRepository.save(harvest);
        return harvestMapper.harvestToHarvestResponseDTO(harvest);
    }

    @Override
    public HarvestResponseDTO updateHarvest(Long id, HarvestRequestDTO harvestRequestDTO) {
        Field field = fieldRepository.findById(harvestRequestDTO.getFieldId())
                .orElseThrow(() -> new RuntimeException("Field not found with id: " + harvestRequestDTO.getFieldId()));


        Harvest existingHarvest = harvestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Harvest not found with ID: " + id));

        existingHarvest = harvestMapper.harvestRequestDTOToHarvest(harvestRequestDTO);

        Seasons season = Seasons.fromDate(existingHarvest.getHarvestDate());
        existingHarvest.setSeason(season);

        Harvest updatedHarvest = harvestRepository.save(existingHarvest);


        return harvestMapper.harvestToHarvestResponseDTO(updatedHarvest);
    }

    @Override
    public void deleteHarvest(Long id) {
        if (!harvestRepository.existsById(id)) {
            throw new RuntimeException("Harvest not found with ID: " + id);
        }
        harvestRepository.deleteById(id);
    }

    @Override
    public HarvestResponseDTO getHarvestById(Long id) {

        Harvest harvest = harvestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Harvest not found with ID: " + id));
        return harvestMapper.harvestToHarvestResponseDTO(harvest);
    }

    @Override
    public List<HarvestResponseDTO> getAllHarvests() {

        return harvestRepository.findAll().stream().map(harvestMapper::harvestToHarvestResponseDTO).collect(Collectors.toList());

    }
}
