package com.project.management.infrastructure.mappers;

import com.project.management.domain.model.Customer.Customer;
import com.project.management.domain.model.Person.Fields.DNI;
import com.project.management.domain.model.Person.Fields.Email;
import com.project.management.domain.model.Person.Fields.Name;
import com.project.management.domain.model.Person.Fields.Phone;
import com.project.management.infrastructure.entities.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerMapper {

    public Customer toDomain(CustomerEntity entity) {
        if (entity == null) {
            return null;
        }

        return Customer.builder()
                .id(entity.getId())
                .name(new Name(entity.getName()))
                .dni(new DNI(entity.getDni()))
                .phone(new Phone(entity.getPhone()))
                .email(new Email(entity.getEmail()))
                .build();
    }

    public CustomerEntity toEntity(Customer domain) {
        if (domain == null) {
            return null;
        }

        return CustomerEntity.builder()
                .id(domain.getId())
                .name(domain.getName().getName())
                .dni(domain.getDni().getDNI())
                .phone(domain.getPhone().getPhone())
                .email(domain.getEmail().getEmail())
                .build();
    }
}
