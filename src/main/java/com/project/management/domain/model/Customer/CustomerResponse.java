package com.project.management.domain.model.Customer;

import com.project.management.domain.model.Person.PersonData;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class CustomerResponse extends PersonData {

    private String id;

}
