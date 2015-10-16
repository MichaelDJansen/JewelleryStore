package com.ProgrammersRUs.Domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 16/10/2015.
 */
public class AddressTest {

    Address address;

    private String streetNumber;
    private String streetName;
    private String town;
    private String province;
    private String postalCode;

    @Before
    public void setUp() throws Exception
    {
        streetNumber = "55";
        streetName = "March Street";
        town = "Cape Town";
        province = "Western Cape";
        postalCode = "8001";
    }

    @Test
    public void testCreation() throws Exception
    {
        address = new Address.Builder(streetNumber,streetName,town,province,postalCode).build();

        Assert.assertNotNull(address);
        Assert.assertEquals(streetName,address.getStreetName());
    }

    @After
    public void tearDown() throws Exception
    {

    }
}
