package com.project.management.infrastructure.Adapters.mechanicAdapter;

import com.project.management.domain.model.Mechanic.Mechanic;
import com.project.management.domain.model.repository.MechanicRepository;
import com.project.management.infrastructure.entities.MechanicEntity;
import com.project.management.infrastructure.mappers.MechanicMapper;
import com.project.management.infrastructure.repositories.JpaMechanicRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class mechanicAdapter implements MechanicRepository {

    private final JpaMechanicRepository jpaMechanicRepository;
    private final MechanicMapper mechanicMapper;

    public mechanicAdapter(JpaMechanicRepository jpaMechanicRepository, MechanicMapper mechanicMapper){
        this.jpaMechanicRepository = jpaMechanicRepository;
        this.mechanicMapper = mechanicMapper;
    }

    @Override
    public MechanicEntity createMechanic(Mechanic mechanic){
        MechanicEntity mechanicEntity = mechanicMapper.toEntity(mechanic);
        MechanicEntity savedEntity = jpaMechanicRepository.save(mechanicEntity);
        return savedEntity;
    }

    @Override
    public Optional<MechanicEntity> findByDni(String id){
        MechanicEntity entity = jpaMechanicRepository.findByDni(id);
        return Optional.ofNullable(entity);
    }
}
