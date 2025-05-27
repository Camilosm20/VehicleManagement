package com.project.management.domain.model.Repairs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RepairsResponse {

   private String id;
   private Date date_repair;
   private String id_mechanic;

}
