package com.project.management.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "mechanic")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
@NoArgsConstructor
@SuperBuilder
public class MechanicEntity extends PersonEntity {
}
