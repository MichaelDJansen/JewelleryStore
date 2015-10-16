package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Name;

/**
 * Created by Michael on 16/10/2015.
 */
public class NameFactory {
    public static Name createName(String firstName,String surname,String middleName){
        Name name = new Name.Builder(firstName,surname).middleName(middleName).build();

        return name;
    }
}
