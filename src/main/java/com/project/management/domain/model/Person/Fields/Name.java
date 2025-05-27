package com.project.management.domain.model.Person.Fields;

import com.project.management.domain.model.Exceptions.BussinesExceptions;
import lombok.Getter;

@Getter
public class Name {

    private String name;

    public Name(String name){
        if (name.isEmpty() || name == null){
            throw new BussinesExceptions("Name is required");
        }else if (name.length() > 100){
            throw new BussinesExceptions("Name less than 100 characters");
        }else if (name.matches("[a-zA-Z]+")){
            throw new BussinesExceptions("Field Name only letters are allowed");
        }else{
            this.name = name;
        }
    }

}
