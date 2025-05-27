package com.project.management.domain.model.Mechanic;

import com.project.management.domain.model.Person.PersonData;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class MechanicResponse extends PersonData {

    private String id;

}
