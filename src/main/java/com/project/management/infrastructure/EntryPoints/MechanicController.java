package com.project.management.infrastructure.EntryPoints;

import com.project.management.domain.request.mechanic.MechanicCreateRequestDTO;
import com.project.management.domain.response.mechanic.MechanicResponseDTO;
import com.project.management.domain.usecase.mechanicUseCase.MechanicUseCase;
import com.project.management.infrastructure.entities.MechanicEntity;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mechanic")
public class MechanicController {

    private final MechanicUseCase mechanicUseCase;

    public MechanicController(MechanicUseCase mechanicUseCase){
        this.mechanicUseCase = mechanicUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<MechanicResponseDTO> createMechanic(@Valid @RequestBody MechanicCreateRequestDTO mechanicRequest){
        MechanicEntity mechanicCreate = mechanicUseCase.createMechanic(mechanicRequest);
        MechanicResponseDTO responseDTO = MechanicResponseDTO.builder()
                .data(mechanicCreate)
                .status("SUCCESS")
                .message("Mechanic create successfully")
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
