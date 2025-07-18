package com.project.management.domain.response.customer;

import com.project.management.domain.model.Customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDTO<T> {

    private Customer data;
    private String status;
    private String message;
}
