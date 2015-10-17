package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Name;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 17/10/2015.
 */
public class NameFactoryTest {

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
