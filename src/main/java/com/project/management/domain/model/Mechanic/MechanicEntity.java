package com.project.management.domain.model.Mechanic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MechanicEntity {

    private MechanicResponse data;
    private String status;
    private String massage;
}
