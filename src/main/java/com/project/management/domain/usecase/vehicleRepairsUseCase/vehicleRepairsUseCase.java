package com.project.management.domain.usecase.vehicleRepairsUseCase;

import com.project.management.domain.model.repository.VehicleRepairsRepository;

public class vehicleRepairsUseCase {

    private VehicleRepairsRepository vehicleRepairsRepository;

    public vehicleRepairsUseCase(VehicleRepairsRepository vehicleRepairsRepository){
        this.vehicleRepairsRepository = vehicleRepairsRepository;
    }
}
