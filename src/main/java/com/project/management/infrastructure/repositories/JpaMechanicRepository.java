package com.project.management.infrastructure.repositories;

import com.project.management.infrastructure.entities.MechanicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMechanicRepository extends JpaRepository<MechanicEntity, String> {

    MechanicEntity findByDni(String id);

}
