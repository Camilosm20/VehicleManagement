package com.project.management.domain.request.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerCreateRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be less than or equal to 100 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Field Name only letters and spaces are allowed")
    private String name;

    @NotBlank(message = "DNI is required")
    @Size(max = 30, message = "DNI must be less than or equal to 30 characters")
    @JsonProperty("DNI")
    private String dni;

    private Integer phone;

    @NotBlank(message = "Email is required")
    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email format")
    private String email;
}
