package com.aidar.citrotrack.repository;

import com.aidar.citrotrack.model.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository   extends JpaRepository<Tree, Long> {
}
