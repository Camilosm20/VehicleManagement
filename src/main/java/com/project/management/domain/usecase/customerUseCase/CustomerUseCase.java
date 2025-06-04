package com.project.management.domain.usecase.customerUseCase;

import com.project.management.domain.model.Customer.Customer;
import com.project.management.domain.model.Exceptions.BussinesExceptions;
import com.project.management.domain.model.repository.CustomerRepository;
import com.project.management.infrastructure.entities.CustomerEntity;

import java.util.Optional;
import java.util.UUID;

public class CustomerUseCase {

    private final CustomerRepository customerRepository;

    public CustomerUseCase(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customerToCreate){
        if (customerToCreate == null){
            throw new BussinesExceptions("Customer data is required.");
        }

        Optional<Customer> existingCustomer = customerRepository.findByDni(customerToCreate.getDni().getDNI());

        if (existingCustomer.isPresent()){
            throw new BussinesExceptions("A customer with DNI " + customerToCreate.getDni().getDNI() + " already exists.");
        }

        Customer savedCustomer = customerRepository.createCustomer(customerToCreate);

        return savedCustomer;
    }
}
