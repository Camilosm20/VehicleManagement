package com.project.management.domain.model.repository;

import com.project.management.domain.model.Mechanic.Mechanic;
import com.project.management.infrastructure.entities.MechanicEntity;

import java.util.Optional;

public interface MechanicRepository {

    MechanicEntity createMechanic(Mechanic mechanic);
    Optional<MechanicEntity> findByDni(String id);
}
