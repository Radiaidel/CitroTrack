package com.aidar.citrotrack.dto.HarvestDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetailIdDTO implements Serializable {
    private Long harvestId;
    private Long treeId;
}
