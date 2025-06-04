package com.project.management.infrastructure.repositories;

import com.project.management.infrastructure.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, String> {

    CustomerEntity findByDni(String dni);
}
