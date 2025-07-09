package com.project.management.infrastructure.mappers;

import com.project.management.domain.model.Mechanic.Mechanic;
import com.project.management.domain.model.Person.Fields.DNI;
import com.project.management.domain.model.Person.Fields.Email;
import com.project.management.domain.model.Person.Fields.Name;
import com.project.management.domain.model.Person.Fields.Phone;
import com.project.management.infrastructure.entities.MechanicEntity;
import org.springframework.stereotype.Component;

@Component
public class MechanicMapper {

    public Mechanic toDomain(MechanicEntity entity){
        if (entity == null){
            return null;
        }

        return Mechanic.builder()
                .id(entity.getId())
                .name(new Name(entity.getName()))
                .dni(new DNI(entity.getDni()))
                .phone(new Phone(entity.getPhone()))
                .email(new Email(entity.getEmail()))
                .build();
    }

    public MechanicEntity toEntity(Mechanic domain) {
        if (domain == null) {
            return null;
        }

        return MechanicEntity.builder()
                .id(domain.getId())
                .name(domain.getName().getName())
                .dni(domain.getDni().getDNI())
                .phone(domain.getPhone().getPhone())
                .email(domain.getEmail().getEmail())
                .build();
    }
}
