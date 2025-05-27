package com.project.management.domain.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEntity {

    private CustomerResponse data;
    private String status;
    private String massage;

}
