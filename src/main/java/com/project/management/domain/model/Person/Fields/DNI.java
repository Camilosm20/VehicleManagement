package com.project.management.domain.model.Person.Fields;

import com.project.management.domain.model.Exceptions.BussinesExceptions;
import lombok.Getter;

@Getter
public class DNI {

    private String DNI;

    public DNI(String DNI){

        if (DNI.isEmpty() || DNI == null){
            throw new BussinesExceptions("DNI is required");
        }else if(DNI.length() < 10){
            throw new BussinesExceptions("DNI less than 10 characters");
//        }else if(){ aqui va la excepcion para cuando existe ya en la base de datos
        }else{
            this.DNI = DNI;
        }

    }
}
