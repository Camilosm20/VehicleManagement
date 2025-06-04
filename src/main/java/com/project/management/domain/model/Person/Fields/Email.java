package com.project.management.domain.model.Person.Fields;

import com.project.management.domain.model.Exceptions.BussinesExceptions;
import lombok.Getter;

@Getter
public class Email {

    private String email;

    public Email (String email){
        if (!email.toLowerCase().contains("@")){
            throw new BussinesExceptions("the email must contain @");
        }else{
            this.email = email;
        }
    }
}
