package com.ProgrammersRUs.Domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 16/10/2015.
 */
public class EmployeeTest {

    Employee employee;
    private Name name;
    private String username;
    private String password;

    @Before
    public void setUp() throws Exception
    {
        name = new Name.Builder("Catherine","Great").middleName("the").build();
        username = "Mike101";
        password = "123456";
    }

    @Test
    public void testCreation() throws Exception
    {
        employee = new Employee.Builder(name,username,password).build();

        Assert.assertNotNull(employee);
        Assert.assertEquals(username,employee.getUsername());
    }

    @After
    public void tearDown() throws Exception
    {

    }
}
