package com.ProgrammersRUs.Domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 16/10/2015.
 */
public class NameTest {

    Name name;

    private String firstName;
    private String middleName;
    private String surname;

    @Before
    public void setUp() throws Exception
    {
        firstName = "Michael";
        middleName = "An";
        surname = "Gelo";
    }

    @Test
    public void testCreation() throws Exception
    {
        name = new Name.Builder(firstName,surname).middleName(middleName).build();

        Assert.assertNotNull(name);
        Assert.assertEquals(firstName,name.getFirstName());
    }

    @After
    public void tearDown() throws Exception
    {

    }
}
