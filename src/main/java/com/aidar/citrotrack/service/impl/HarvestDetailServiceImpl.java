package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.HarvestDetail.HarvestDetailRequestDTO;
import com.aidar.citrotrack.dto.HarvestDetail.HarvestDetailResponseDTO;
import com.aidar.citrotrack.model.Harvest;
import com.aidar.citrotrack.model.HarvestDetail;
import com.aidar.citrotrack.model.HarvestDetailId;
import com.aidar.citrotrack.model.Tree;
import com.aidar.citrotrack.repository.HarvestDetailRepository;
import com.aidar.citrotrack.repository.HarvestRepository;
import com.aidar.citrotrack.repository.TreeRepository;
import com.aidar.citrotrack.service.HarvestDetailService;
import com.aidar.citrotrack.mapper.HarvestDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class HarvestDetailServiceImpl implements HarvestDetailService {

    private final HarvestDetailRepository harvestDetailRepository;
    private final HarvestRepository harvestRepository;
    private final TreeRepository treeRepository;
    private final HarvestDetailMapper harvestDetailMapper;

    @Override
    public HarvestDetailResponseDTO createHarvestDetail(HarvestDetailRequestDTO harvestDetailRequestDTO) {
        Harvest harvest = harvestRepository.findById(harvestDetailRequestDTO.harvestId())
                .orElseThrow(() -> new RuntimeException("Harvest not found"));

        Tree tree = treeRepository.findById(harvestDetailRequestDTO.treeId())
                .orElseThrow(() -> new RuntimeException("Tree not found"));

        HarvestDetailId id = new HarvestDetailId(harvestDetailRequestDTO.harvestId(),
                harvestDetailRequestDTO.treeId());
        if (harvestDetailRepository.existsById(id)) {
            throw new IllegalArgumentException("Harvest detail already exists for this harvest and tree");
        }

        HarvestDetail harvestDetail = harvestDetailMapper.toEntity(harvestDetailRequestDTO);
        harvestDetail.setHarvest(harvest);
        harvestDetail.setTree(tree);
        harvestDetail.setQuantity(harvestDetailRequestDTO.quantity());

        recalculateTotalQuantity(harvest);

        HarvestDetail savedHarvestDetail = harvestDetailRepository.save(harvestDetail);
        return harvestDetailMapper.toResponse(savedHarvestDetail);
    }

    @Override
    @Transactional(readOnly = true)
    public HarvestDetailResponseDTO getHarvestDetail(Long harvestId, Long treeId) {
        HarvestDetailId id = new HarvestDetailId(harvestId, treeId);
        HarvestDetail harvestDetail = harvestDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Harvest detail not found"));
        return harvestDetailMapper.toResponse(harvestDetail);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HarvestDetailResponseDTO> getHarvestDetailsByHarvest(Long harvestId) {
        return harvestDetailRepository.findByHarvestId(harvestId).stream()
                .map(harvestDetailMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public HarvestDetailResponseDTO updateHarvestDetail(Long harvestId, Long treeId,
                                                        HarvestDetailRequestDTO harvestDetailRequestDTO) {
        HarvestDetailId id = new HarvestDetailId(harvestId, treeId);

        HarvestDetail existingHarvestDetail = harvestDetailRepository.findById(id)
                .orElse(null);

        if (existingHarvestDetail != null) {
            existingHarvestDetail.setQuantity(harvestDetailRequestDTO.quantity());
            HarvestDetail updatedHarvestDetail = harvestDetailRepository.save(existingHarvestDetail);
            return harvestDetailMapper.toResponse(updatedHarvestDetail);
        } else {
            throw new RuntimeException("Harvest detail not found for this harvest and tree combination.");
        }
    }

    @Transactional
    @Override
    public void deleteHarvestDetail(Long harvestId, Long treeId) {
        HarvestDetailId id =  HarvestDetailId.builder().harvestId(harvestId).treeId(treeId).build();

//        recalculateTotalQuantity(harvest);
        HarvestDetail harvestDelete = harvestDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Harvest detail not found"));


//        harvestDetailRepository.delete(harvestDelete);
        harvestDetailRepository.deleteByCustomQuery(id);

        harvestDetailRepository.flush();

    }


    private void recalculateTotalQuantity(Harvest harvest) {
        double total = harvest.getHarvestDetails().stream()
                .mapToDouble(HarvestDetail::getQuantity)
                .sum();
        harvest.setTotalQuantity(total);
        harvestRepository.save(harvest);
    }

}