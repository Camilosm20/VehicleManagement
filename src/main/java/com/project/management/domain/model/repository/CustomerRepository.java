package com.project.management.domain.model.repository;

import com.project.management.domain.model.Customer.Customer;
import com.project.management.infrastructure.entities.CustomerEntity;

import java.util.Optional;

public interface CustomerRepository {
    //CRUD
    Customer save(Customer customer);
    Optional<Customer> findByDni(String dni);
    Customer createCustomer(Customer customer);

}
