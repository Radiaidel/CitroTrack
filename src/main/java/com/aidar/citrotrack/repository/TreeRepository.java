package com.aidar.citrotrack.repository;

import com.aidar.citrotrack.model.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepository   extends JpaRepository<Tree, Long> {
}
