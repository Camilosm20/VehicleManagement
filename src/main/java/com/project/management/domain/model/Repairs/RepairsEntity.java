package com.project.management.domain.model.Repairs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RepairsEntity {

    private RepairsResponse data;
    private String status;
    private String massage;

}
