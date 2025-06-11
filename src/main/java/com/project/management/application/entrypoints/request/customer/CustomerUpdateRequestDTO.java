package com.project.management.application.entrypoints.request.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerUpdateRequestDTO {

    @Size(max = 100, message = "Name must be less than or equal to 100 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Field Name only letters and spaces are allowed")
    @JsonProperty("name")
    private String name;

    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email format")
    private String email;

    private Integer phone;
}
