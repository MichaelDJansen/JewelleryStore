package com.ProgrammersRUs.Domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 16/10/2015.
 */
public class ContactInformationTest {

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
        contactInformation = new ContactInformation.Builder(cellphone,email).telephone(telephone).build();

        Assert.assertNotNull(contactInformation);
        Assert.assertEquals(email,contactInformation.getEmail());
    }

    @After
    public void tearDown() throws Exception
    {

    }
}
