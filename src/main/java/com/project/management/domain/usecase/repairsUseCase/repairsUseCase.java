package com.project.management.domain.usecase.repairsUseCase;

import com.project.management.domain.model.repository.RepairsRepository;

public class repairsUseCase {

    private RepairsRepository repairsRepository;

    public repairsUseCase(RepairsRepository repairsRepository){
        this.repairsRepository = repairsRepository;
    }
}
