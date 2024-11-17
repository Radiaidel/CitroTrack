package com.aidar.citrotrack.repository;

import com.aidar.citrotrack.model.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestRepository  extends JpaRepository<Harvest, Long> {
}
