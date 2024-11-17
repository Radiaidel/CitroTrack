package com.aidar.citrotrack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetailId implements Serializable {
    @Column(name = "harvest_id")
    private Long harvestId;

    @Column(name = "tree_id")
    private Long treeId;
}
