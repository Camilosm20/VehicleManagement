package com.project.management.domain.response.customer;

import com.project.management.infrastructure.entities.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntityResponseDTO {

    private CustomerEntity data;
    private String status;
    private String message;
}
