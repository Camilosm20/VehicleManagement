package com.project.management.domain.config.usecaseconfig;

import com.project.management.domain.model.repository.*;
import com.project.management.domain.usecase.customerUseCase.customerUseCase;
import com.project.management.domain.usecase.mechanicUseCase.mechanicUseCase;
import com.project.management.domain.usecase.repairsUseCase.repairsUseCase;
import com.project.management.domain.usecase.vehicleRepairsUseCase.vehicleRepairsUseCase;
import com.project.management.domain.usecase.vehicleUseCase.vehicleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public customerUseCase customerUseCase(CustomerRepository repository){
        return new customerUseCase(repository);
    }

    @Bean
    public mechanicUseCase mechanicUseCase(MechanicRepository repository){
        return new mechanicUseCase(repository);
    }

    @Bean
    public repairsUseCase repairsUseCase (RepairsRepository repository){
        return new repairsUseCase(repository);
    }

    @Bean
    public vehicleRepairsUseCase vehicleRepairsUseCase(VehicleRepairsRepository repository){
        return new vehicleRepairsUseCase(repository);
    }

    @Bean
    public vehicleUseCase vehicleUseCase(VehicleRepository repository){
        return new vehicleUseCase(repository);
    }
}
