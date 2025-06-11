package com.project.management.domain.usecase.customerUseCase;

import com.project.management.application.entrypoints.request.customer.CustomerUpdateRequestDTO;
import com.project.management.domain.model.Customer.Customer;
import com.project.management.domain.model.Exceptions.BussinesExceptions;
import com.project.management.domain.model.Person.Fields.Email;
import com.project.management.domain.model.Person.Fields.Name;
import com.project.management.domain.model.Person.Fields.Phone;
import com.project.management.domain.model.repository.CustomerRepository;
import com.project.management.infrastructure.entities.CustomerEntity;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Optional;

@Log4j2
public class CustomerUseCase {

    private final CustomerRepository customerRepository;

    public CustomerUseCase(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customerToCreate){
        if (customerToCreate == null){
            throw new BussinesExceptions("Customer data is required.");
        }

        Optional<Customer> existingCustomer = customerRepository.findByDni(customerToCreate.getDni());

        if (existingCustomer.isPresent()){
            throw new BussinesExceptions("A customer with DNI " + customerToCreate.getDni() + " already exists.");
        }

        Customer savedCustomer = customerRepository.createCustomer(customerToCreate);

        return savedCustomer;
    }

    public Customer editCustomer(String dni, CustomerUpdateRequestDTO customerToUpdate){

        if (customerToUpdate == null){
            throw new BussinesExceptions("Customer data to update is required");
        }else if (dni == null || dni.trim().isEmpty()){
            throw new BussinesExceptions("dni to search is required");
        }

        Optional<Customer> customer = customerRepository.findByDni(dni);

        if (!customer.isPresent()){
            throw new BussinesExceptions("Customer don´t existing in data base");
        }

        Customer customerToEdit = customer.get();

        if (customerToUpdate.getName() != null){
            customerToEdit.setName(customerToUpdate.getName());
        }

        if (customerToUpdate.getPhone() != null){
            customerToEdit.setPhone(customerToUpdate.getPhone());
        }

        if (customerToUpdate.getEmail() != null){
            customerToEdit.setEmail(customerToUpdate.getEmail());
        }

        Customer updateCustomer = customerRepository.save(customerToEdit);

        return updateCustomer;
    }

    public Boolean deleteCustomer(String dni){
        if (dni == null || dni.trim().isEmpty()){
            throw new BussinesExceptions("dni to search is required");
        }

        Optional<Customer> customer = customerRepository.findByDni(dni);

        if (!customer.isPresent()){
            throw new BussinesExceptions("Customer don´t existing in data base");
        }

        Customer customerToDelete = customer.get();

        customerRepository.deleteCustomer(customerToDelete);

        return true;
    }

    public List<Customer> findAllCustomer(){
        List<Customer> customerList = customerRepository.findAllCustomer();
        return customerList;
    }

    public Customer findCustomerByDni(String dni){
        if (dni == null || dni.trim().isEmpty()){
            throw new BussinesExceptions("dni to search is required");
        }

        Optional<Customer> customer = customerRepository.findByDni(dni);

        if (!customer.isPresent()){
            throw new BussinesExceptions("Customer don´t existing in data base");
        }

        Customer customerToSend = customer.get();

        return customerToSend;
    }
}
