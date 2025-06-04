package com.project.management.domain.model.Person.Fields;

import com.project.management.domain.model.Exceptions.BussinesExceptions;
import lombok.Getter;

@Getter
public class Phone {

    private Integer phone;

    public Phone(Integer phone){
        if (phone < 0){
            throw new BussinesExceptions("The phone number must be greater than 0.");
        }else{
            this.phone = phone;
        }
    }
}
