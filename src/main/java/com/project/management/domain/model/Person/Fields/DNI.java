package com.project.management.domain.model.Person.Fields;

import com.project.management.domain.model.Exceptions.BussinesExceptions;
import lombok.Getter;

@Getter
public class DNI {

    private String DNI;

    public DNI(String DNI){

        if (DNI.isEmpty() || DNI == null){
            throw new BussinesExceptions("DNI is required");
        }else if(DNI.length() < 15){
            throw new BussinesExceptions("DNI less than 15 characters");
        }

    }
}
