package com.project.management.domain.model.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public abstract class PersonData {

    private String name;
    private String DNI;
    private int phone;
    private String email;

}
