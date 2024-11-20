package com.aidar.citrotrack.repository.custom;

import com.aidar.citrotrack.model.Farm;

import java.util.List;
import java.util.Map;

public interface FarmRepositoryCustom {
    List<Farm> searchFarms(Map<String, Object> criteria);
}
