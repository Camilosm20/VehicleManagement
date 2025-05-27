package com.project.management.domain.model.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleEntity {

    private VehicleResponse data;
    private String Status;
    private String Massage;

}
