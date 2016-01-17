package com.ProgrammersRUs.Domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 16/10/2015.
 */
public class CustomerTest {

    Customer customer;

    private Name name;
    private ContactInformation contactInformation;
    private Address address;

    @Before
    public void setUp() throws Exception
    {
        name = new Name.Builder("Michael","Jansen").build();
        contactInformation = new ContactInformation.Builder("0735589465","KarryHelgen@hotmail.com").build();
        address = new Address.Builder("55","March Street","Cape Town","Western Cape","8001").build();
    }

    @Test
    public void testCreation() throws Exception
    {
        customer = new Customer.Builder(name,contactInformation).build();

        Assert.assertNotNull(customer);
        Assert.assertEquals("0735589465",customer.getContactInformation().getCellphone());
    }

    @After
    public void tearDown() throws Exception
    {

    }
}
