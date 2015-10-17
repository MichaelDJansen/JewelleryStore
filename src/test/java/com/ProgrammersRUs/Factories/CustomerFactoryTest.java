package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.ContactInformation;
import com.ProgrammersRUs.Domain.Customer;
import com.ProgrammersRUs.Domain.Name;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 17/10/2015.
 */
public class CustomerFactoryTest {

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
        customer = CustomerFactory.createCustomer(name,contactInformation,address);

        Assert.assertNotNull(customer);
        Assert.assertEquals("0735589465",customer.getContactInformation().getCellphone());
    }

    @After
    public void tearDown() throws Exception
    {

    }

}
