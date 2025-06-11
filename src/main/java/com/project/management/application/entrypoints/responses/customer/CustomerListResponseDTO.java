package com.project.management.application.entrypoints.responses.customer;


import com.project.management.domain.model.Customer.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerListResponseDTO {

    private List<Customer> data;
    private String status;
    private String message;

}
