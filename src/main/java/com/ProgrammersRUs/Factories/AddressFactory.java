package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Address;

/**
 * Created by Michael on 16/10/2015.
 */
public class AddressFactory {
    public static Address createAddress(String streetNumber,String streetName,String town,String province,String postalCode){
        Address address = new Address.Builder(streetNumber,streetName,town,province,postalCode).build();

        return address;
    }
}
