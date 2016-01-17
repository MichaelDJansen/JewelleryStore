package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.ContactInformation;
import com.ProgrammersRUs.Domain.Customer;
import com.ProgrammersRUs.Domain.Name;

/**
 * Created by Michael on 16/10/2015.
 */
public class CustomerFactory {
    public static Customer createCustomer(Name name,String companyName, ContactInformation contactInformation,Address address, String username, String password){
        Customer customer = new Customer.Builder(name,contactInformation).companyName(companyName).address(address).username(username).password(password).build();
        return customer;
    }
}
