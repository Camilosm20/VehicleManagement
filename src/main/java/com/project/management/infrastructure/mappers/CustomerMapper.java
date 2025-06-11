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
                .name(entity.getName())
                .dni(entity.getDni())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .build();
    }

    public CustomerEntity toEntity(Customer domain) {
        if (domain == null) {
            return null;
        }

        return CustomerEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .dni(domain.getDni())
                .phone(domain.getPhone())
                .email(domain.getEmail())
                .build();
    }
}
