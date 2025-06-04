package com.project.management.domain.usecase.mechanicUseCase;

import com.project.management.domain.model.repository.MechanicRepository;

public class mechanicUseCase {

    private MechanicRepository mechanicRepository;

    public mechanicUseCase(MechanicRepository repository){
        this.mechanicRepository = mechanicRepository;
    }
}
