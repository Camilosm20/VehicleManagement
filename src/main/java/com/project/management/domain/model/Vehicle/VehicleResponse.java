package com.project.management.domain.model.Vehicle;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleResponse {

    private String id;
    private String brand;
    private String color;
    private String id_customer;

}
