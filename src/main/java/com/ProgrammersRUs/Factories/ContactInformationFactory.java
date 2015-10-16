package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.ContactInformation;

/**
 * Created by Michael on 16/10/2015.
 */
public class ContactInformationFactory {
    public static ContactInformation createContactInformation(String cellphone,String email,String telephone){
        ContactInformation contactInformation = new ContactInformation.Builder(cellphone,email).telephone(telephone).build();

        return contactInformation;
    }
}
