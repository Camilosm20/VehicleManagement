package com.project.management.application.usecaseconfig;

import com.project.management.domain.model.repository.*;
import com.project.management.domain.usecase.customerUseCase.CustomerUseCase;
import com.project.management.domain.usecase.mechanicUseCase.mechanicUseCase;
import com.project.management.domain.usecase.repairsUseCase.repairsUseCase;
import com.project.management.domain.usecase.vehicleRepairsUseCase.vehicleRepairsUseCase;
import com.project.management.domain.usecase.vehicleUseCase.vehicleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CustomerUseCase customerUseCase(CustomerRepository repository){
        return new CustomerUseCase(repository);
    }

//    @Bean
//    public mechanicUseCase mechanicUseCase(MechanicRepository repository){
//        return new mechanicUseCase(repository);
//    }
//
//    @Bean
//    public repairsUseCase repairsUseCase (RepairsRepository repository){
//        return new repairsUseCase(repository);
//    }
//
//    @Bean
//    public vehicleRepairsUseCase vehicleRepairsUseCase(VehicleRepairsRepository repository){
//        return new vehicleRepairsUseCase(repository);
//    }
//
//    @Bean
//    public vehicleUseCase vehicleUseCase(VehicleRepository repository){
//        return new vehicleUseCase(repository);
//    }
}
