package com.aidar.citrotrack.repository;

import com.aidar.citrotrack.model.Farm;
import com.aidar.citrotrack.repository.custom.FarmRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository  extends JpaRepository< Farm, Long> , FarmRepositoryCustom {
}
