package com.project.management.domain.response.mechanic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MechanicResponseDTO<T> {

    private T data;
    private String status;
    private String message;
}
