package com.project.management.domain.model.Mechanic;

import com.project.management.domain.model.Person.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Mechanic extends Person {

    private String id;

}
