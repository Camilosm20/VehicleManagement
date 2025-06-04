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
        // Cuando mapeas de entidad JPA a dominio, construyes las clases de valor
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
        // Cuando mapeas de dominio a entidad JPA, extraes los String de las clases de valor
        return CustomerEntity.builder()
                .id(domain.getId()) // Asegúrate de que el ID se maneje correctamente (ej. si JPA lo genera)
                .name(domain.getName().getName()) // Asumiendo que Name tiene un getter getName() o getValue()
                .dni(domain.getDni().getDNI())
                .phone(domain.getPhone().getPhone())
                .email(domain.getEmail().getEmail())
                .build();
    }
}
