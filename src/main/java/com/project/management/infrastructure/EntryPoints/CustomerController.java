package com.project.management.infrastructure.EntryPoints;

import com.project.management.application.entrypoints.request.CustomerCreateRequestDTO;
import com.project.management.application.entrypoints.responses.CustomerResponseDTO;
import com.project.management.domain.model.Customer.Customer;
import com.project.management.domain.model.Exceptions.BussinesExceptions;
import com.project.management.domain.model.Person.Fields.DNI;
import com.project.management.domain.model.Person.Fields.Email;
import com.project.management.domain.model.Person.Fields.Name;
import com.project.management.domain.model.Person.Fields.Phone;
import com.project.management.domain.usecase.customerUseCase.CustomerUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                    .name(new Name(customerRequest.getName()))
                    .dni(new DNI(customerRequest.getDni()))
                    .phone(new Phone(customerRequest.getPhone()))
                    .email(new Email(customerRequest.getEmail()))
                    .build();
            Customer createdCustomer = customerUseCase.createCustomer(customerToCreate);

            CustomerResponseDTO response = CustomerResponseDTO.builder()
                    .data(createdCustomer) // El objeto Customer de dominio creado
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
        } catch (Exception e) {

            CustomerResponseDTO errorResponse = CustomerResponseDTO.builder()
                    .data(null)
                    .status("ERROR")
                    .message("An unexpected error occurred: " + e.getMessage())
                    .build();

            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
