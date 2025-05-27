package com.project.management.domain.model.VehicleRepairs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleRepairsResponse {

    private String id;
    private String id_vehicle;
    private String id_repairs;

}
