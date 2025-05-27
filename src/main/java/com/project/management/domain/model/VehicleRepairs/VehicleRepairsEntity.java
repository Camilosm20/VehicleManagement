package com.project.management.domain.model.VehicleRepairs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleRepairsEntity {

    private VehicleRepairsResponse data;
    private String status;
    private String massage;

}
