package com.project.management.infrastructure.EntryPoints;

import com.project.management.application.entrypoints.request.customer.CustomerCreateRequestDTO;
import com.project.management.application.entrypoints.request.customer.CustomerUpdateRequestDTO;
import com.project.management.application.entrypoints.responses.customer.CustomerListResponseDTO;
import com.project.management.application.entrypoints.responses.customer.CustomerResponseDTO;
import com.project.management.domain.model.Customer.Customer;
import com.project.management.domain.model.Exceptions.BussinesExceptions;
import com.project.management.domain.usecase.customerUseCase.CustomerUseCase;
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
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CustomerCreateRequestDTO customerRequest){

        try {

            Customer customerToCreate = Customer.builder()
                    .name(customerRequest.getName())
                    .dni(customerRequest.getDni())
                    .phone(customerRequest.getPhone())
                    .email(customerRequest.getEmail())
                    .build();
            Customer createdCustomer = customerUseCase.createCustomer(customerToCreate);

            CustomerResponseDTO response = CustomerResponseDTO.builder()
                    .data(createdCustomer)
                    .status("SUCCESS")
                    .message("Customer created successfully")
                    .build();

            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (BussinesExceptions e) {

            CustomerResponseDTO errorResponse = CustomerResponseDTO.builder()
                    .data(null)
                    .status("ERROR")
                    .message(e.getMessage())
                    .build();

            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("edit/{dni}")
    public ResponseEntity<CustomerResponseDTO> editCustomer(
            @PathVariable String dni,
            @Valid @RequestBody CustomerUpdateRequestDTO requestDTO){
        try{
            Customer updateCustomer = customerUseCase.editCustomer(dni, requestDTO);

            CustomerResponseDTO response = CustomerResponseDTO.builder()
                    .data(updateCustomer)
                    .status("SUCCESS")
                    .message("Customer updated successfully")
                    .build();

            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (BussinesExceptions e){
            CustomerResponseDTO errorResponse = CustomerResponseDTO.builder()
                    .data(null)
                    .status("ERROR")
                    .message(e.getMessage())
                    .build();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("delete/{dni}")
    public ResponseEntity<CustomerResponseDTO> deleteCustomer(
            @PathVariable String dni
    ){
        try{
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
        }catch (BussinesExceptions e){
            CustomerResponseDTO errorResponse = CustomerResponseDTO.builder()
                    .data(null)
                    .status("ERROR")
                    .message(e.getMessage())
                    .build();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<CustomerListResponseDTO> findAllCustomer(){
        try{
            List<Customer> customerList = customerUseCase.findAllCustomer();

            CustomerListResponseDTO customers = CustomerListResponseDTO.builder()
                    .data(customerList)
                    .status("SUCCESS")
                    .message("Customer List successfully")
                    .build();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }catch (BussinesExceptions e){
            CustomerListResponseDTO errorResponse = CustomerListResponseDTO.builder()
                    .data(null)
                    .status("ERROR")
                    .message(e.getMessage())
                    .build();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{dni}")
    public ResponseEntity<CustomerResponseDTO> findCustomerByDni(@PathVariable String dni){
        try{
            Customer customer = customerUseCase.findCustomerByDni(dni);

            CustomerResponseDTO customers = CustomerResponseDTO.builder()
                    .data(customer)
                    .status("SUCCESS")
                    .message("Customer List successfully")
                    .build();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }catch (BussinesExceptions e){
            CustomerResponseDTO errorResponse = CustomerResponseDTO.builder()
                    .data(null)
                    .status("ERROR")
                    .message(e.getMessage())
                    .build();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

}
