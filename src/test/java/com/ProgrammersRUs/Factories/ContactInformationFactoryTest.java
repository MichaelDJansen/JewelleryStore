package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.ContactInformation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 17/10/2015.
 */
public class ContactInformationFactoryTest {

    ContactInformation contactInformation;

    private String email;
    private String telephone;
    private String cellphone;

    @Before
    public void setUp() throws Exception
    {
        email = "haroldBurger@gmail.com";
        telephone = "0215582564";
        cellphone = "0732243546";
    }

    @Test
    public void testCreation() throws Exception
    {
        contactInformation = ContactInformationFactory.createContactInformation(cellphone,email,telephone);

        Assert.assertNotNull(contactInformation);
        Assert.assertEquals(email,contactInformation.getEmail());
    }

    @After
    public void tearDown() throws Exception
    {

    }

}
