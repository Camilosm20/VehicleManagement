package com.project.management.domain.model.repository;

import com.project.management.domain.model.Customer.Customer;
import com.project.management.infrastructure.entities.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    //CRUD
    CustomerEntity save(Customer customer);
    Optional<Customer> findByDni(String dni);
    CustomerEntity createCustomer(Customer customer);
    void deleteCustomer (Customer customer);
    List<Customer> findAllCustomer();
}
