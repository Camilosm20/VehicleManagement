package com.project.management.domain.model.Exceptions;

import com.project.management.domain.response.customer.CustomerResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BussinesExceptions.class)
    public ResponseEntity<CustomerResponseDTO>handleBussinesException(BussinesExceptions ex){
        CustomerResponseDTO errorResponse = CustomerResponseDTO.builder()
                .data(null)
                .status("ERROR")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomerResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        StringBuilder errorMessageBuilder = new StringBuilder("Validation failed: ");
        errors.forEach((field, msg) -> errorMessageBuilder.append(field).append(": ").append(msg).append("; "));

        CustomerResponseDTO errorResponse = CustomerResponseDTO.builder()
                .data(null)
                .status("ERROR")
                .message(errorMessageBuilder.toString())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomerResponseDTO> handleGenericException(Exception ex) {
        CustomerResponseDTO errorResponse = CustomerResponseDTO.builder()
                .data(null)
                .status("ERROR")
                .message("An unexpected server error occurred: " + ex.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
