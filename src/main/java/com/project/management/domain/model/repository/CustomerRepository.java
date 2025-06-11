package com.project.management.domain.model.repository;

import com.project.management.domain.model.Customer.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    //CRUD
    Customer save(Customer customer);
    Optional<Customer> findByDni(String dni);
    Customer createCustomer(Customer customer);
    void deleteCustomer (Customer customer);
    List<Customer> findAllCustomer();
}
