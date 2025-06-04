package com.project.management.domain.usecase.vehicleUseCase;

import com.project.management.domain.model.repository.VehicleRepository;

public class vehicleUseCase {

    private VehicleRepository vehicleRepository;

    public vehicleUseCase(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
}
