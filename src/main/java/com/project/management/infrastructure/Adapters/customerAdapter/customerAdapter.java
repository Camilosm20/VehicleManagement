package com.project.management.infrastructure.Adapters.customerAdapter;

import com.project.management.domain.model.Customer.Customer;
import com.project.management.domain.model.repository.CustomerRepository;
import com.project.management.infrastructure.entities.CustomerEntity;
import com.project.management.infrastructure.mappers.CustomerMapper;
import com.project.management.infrastructure.repositories.JpaCustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class customerAdapter implements CustomerRepository {

    private final JpaCustomerRepository jpaCustomerRepository;
    private final CustomerMapper customerMapper;

    public customerAdapter(JpaCustomerRepository jpaCustomerRepository, CustomerMapper customerMapper){
        this.jpaCustomerRepository = jpaCustomerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer save(Customer customer){
        CustomerEntity customerEntity = customerMapper.toEntity(customer);
        CustomerEntity savedEntity = jpaCustomerRepository.save(customerEntity);
        return customerMapper.toDomain(savedEntity);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        CustomerEntity customerEntity = customerMapper.toEntity(customer);
        CustomerEntity savedEntity = jpaCustomerRepository.save(customerEntity);
        return customerMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Customer> findByDni(String dni) {
        CustomerEntity entity = jpaCustomerRepository.findByDni(dni);
        return Optional.ofNullable(customerMapper.toDomain(entity));
    }

    @Override
    public void deleteCustomer(Customer customer){
        CustomerEntity customerEntity = customerMapper.toEntity(customer);
        jpaCustomerRepository.delete(customerEntity);
    }

    @Override
    public List<Customer> findAllCustomer(){
        List<CustomerEntity> entityList = jpaCustomerRepository.findAll();
        List<Customer> customerList = entityList.stream()
                .map(customerMapper::toDomain)
                .collect(Collectors.toList());
        return customerList;
    }

}
