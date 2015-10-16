package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.ContactInformation;
import com.ProgrammersRUs.Domain.Customer;
import com.ProgrammersRUs.Domain.Name;

/**
 * Created by Michael on 16/10/2015.
 */
public class CustomerFactory {
    public static Customer createCustomer(Name name,ContactInformation contactInformation,Address address){
        Customer customer = new Customer.Builder(name,contactInformation).address(address).build();
        return customer;
    }
}
