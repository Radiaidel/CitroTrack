package com.aidar.citrotrack.repository;

import com.aidar.citrotrack.model.HarvestDetail;
import com.aidar.citrotrack.model.HarvestDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HarvestDetailRepository extends JpaRepository<HarvestDetail , HarvestDetailId> {
    @Query("SELECT hd FROM HarvestDetail hd WHERE hd.harvest.id = :harvestId")
    List<HarvestDetail> findByHarvestId(@Param("harvestId") Long harvestId);

}
