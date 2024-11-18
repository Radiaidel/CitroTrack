package com.aidar.citrotrack.repository;

import com.aidar.citrotrack.model.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HarvestRepository  extends JpaRepository<Harvest, Long> {
}
