package com.project.management.infrastructure.EntryPoints;

import com.project.management.domain.request.customer.CustomerCreateRequestDTO;
import com.project.management.domain.request.customer.CustomerUpdateRequestDTO;
import com.project.management.domain.response.customer.CustomerEntityResponseDTO;
import com.project.management.domain.response.customer.CustomerListResponseDTO;
import com.project.management.domain.response.customer.CustomerResponseDTO;
import com.project.management.domain.model.Customer.Customer;
import com.project.management.domain.model.Exceptions.BussinesExceptions;
import com.project.management.domain.usecase.customerUseCase.CustomerUseCase;
import com.project.management.infrastructure.entities.CustomerEntity;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    public CustomerController (CustomerUseCase customerUseCase){
        this.customerUseCase = customerUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerEntityResponseDTO> createCustomer(@Valid @RequestBody CustomerCreateRequestDTO customerRequest){

        CustomerEntity createdCustomer = customerUseCase.createCustomer(customerRequest);

        CustomerEntityResponseDTO response = CustomerEntityResponseDTO.builder()
                .data(createdCustomer)
                .status("SUCCESS")
                .message("Customer created successfully")
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("edit/{dni}")
    public ResponseEntity<CustomerEntityResponseDTO> editCustomer(
            @PathVariable String dni,
            @Valid @RequestBody CustomerUpdateRequestDTO requestDTO){
        CustomerEntity updateCustomer = customerUseCase.editCustomer(dni, requestDTO);

        CustomerEntityResponseDTO response = CustomerEntityResponseDTO.builder()
                .data(updateCustomer)
                .status("SUCCESS")
                .message("Customer updated successfully")
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete/{dni}")
    public ResponseEntity<CustomerResponseDTO> deleteCustomer(
            @PathVariable String dni
    ){
        Boolean data_response = customerUseCase.deleteCustomer(dni);

        if (data_response){
            CustomerResponseDTO response = CustomerResponseDTO.builder()
                    .data(null)
                    .status("SUCCESS")
                    .message("Customer delete successfully")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            throw new BussinesExceptions("ERROR delete customer");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<CustomerListResponseDTO> findAllCustomer(){
        List<Customer> customerList = customerUseCase.findAllCustomer();

        CustomerListResponseDTO customers = CustomerListResponseDTO.builder()
                .data(customerList)
                .status("SUCCESS")
                .message("Customer List successfully")
                .build();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<CustomerResponseDTO> findCustomerByDni(@PathVariable String dni){
        Customer customer = customerUseCase.findCustomerByDni(dni);

        CustomerResponseDTO customers = CustomerResponseDTO.builder()
                .data(customer)
                .status("SUCCESS")
                .message("Customer List successfully")
                .build();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
