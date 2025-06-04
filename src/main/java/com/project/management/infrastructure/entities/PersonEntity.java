package com.project.management.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class PersonEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(30)")
    private String id;

    @Column(name = "name", length = 100)
    protected String name;

    @Column(name = "DNI", unique = true, length = 30)
    protected String dni;

    @Column(name = "phone")
    protected Integer phone;

    @Column(name = "email", unique = true, length = 100)
    protected String email;
}
