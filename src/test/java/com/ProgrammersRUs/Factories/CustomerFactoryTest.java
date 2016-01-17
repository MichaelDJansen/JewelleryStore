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
    private String companyName;
    private ContactInformation contactInformation;
    private String address;
    private String username;
    private String password;

    @Before
    public void setUp() throws Exception
    {
        name = new Name.Builder("Michael","Jansen").build();
        contactInformation = new ContactInformation.Builder("0735589465","KarryHelgen@hotmail.com").build();
        address = "55 March Street Cape Town Western Cape 8001";
        username = "Mike435";
        password = "Iam_Michael";
    }

    @Test
    public void testCreation() throws Exception
    {
        customer = CustomerFactory.createCustomer(name,companyName,contactInformation,address, username, password);

        Assert.assertNotNull(customer);
        Assert.assertEquals("0735589465",customer.getContactInformation().getCellphone());
    }

    @After
    public void tearDown() throws Exception
    {

    }

}
