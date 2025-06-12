package com.project.management.domain.model.Person;

import com.project.management.domain.model.Person.Fields.DNI; // Importa las clases de valor
import com.project.management.domain.model.Person.Fields.Email;
import com.project.management.domain.model.Person.Fields.Name;
import com.project.management.domain.model.Person.Fields.Phone;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class Person {

    protected String id;

    protected Name name;
    protected DNI dni;
    protected Phone phone;
    protected Email email;


}
