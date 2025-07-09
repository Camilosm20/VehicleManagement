package com.project.management.domain.usecase.mechanicUseCase;

import com.project.management.domain.model.Exceptions.BussinesExceptions;
import com.project.management.domain.model.Mechanic.Mechanic;
import com.project.management.domain.model.Person.Fields.DNI;
import com.project.management.domain.model.Person.Fields.Email;
import com.project.management.domain.model.Person.Fields.Name;
import com.project.management.domain.model.Person.Fields.Phone;
import com.project.management.domain.model.repository.MechanicRepository;
import com.project.management.domain.request.mechanic.MechanicCreateRequestDTO;
import com.project.management.infrastructure.entities.MechanicEntity;

import java.util.Optional;

public class MechanicUseCase {

    private final MechanicRepository mechanicRepository;

    public MechanicUseCase(MechanicRepository repository){
        this.mechanicRepository = repository;
    }

    public MechanicEntity createMechanic(MechanicCreateRequestDTO mechanicRequest){
        if (mechanicRequest == null){
            throw new BussinesExceptions("Mechanic data is required");
        }

        Mechanic mechanicToCreate = Mechanic.builder()
                .name(new Name(mechanicRequest.getName()))
                .dni(new DNI(mechanicRequest.getDni()))
                .email(new Email(mechanicRequest.getEmail()))
                .phone(new Phone(mechanicRequest.getPhone()))
                .build();

        Optional<MechanicEntity> existingMechanic = mechanicRepository.findByDni(mechanicToCreate.getDni().getDNI());

        if (existingMechanic.isPresent()){
            throw new BussinesExceptions("A mechanic with DNI: " + mechanicToCreate.getDni().getDNI() + " already exists.");
        }

        MechanicEntity savedMechanic = mechanicRepository.createMechanic(mechanicToCreate);

        return savedMechanic;
    }
}
