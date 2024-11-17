package com.aidar.citrotrack.repository;

import com.aidar.citrotrack.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository  extends JpaRepository< Farm, Long> {
}
