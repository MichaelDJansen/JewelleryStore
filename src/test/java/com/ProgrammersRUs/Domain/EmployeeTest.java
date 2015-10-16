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
    private Address address;
    private float salary;

    @Before
    public void setUp() throws Exception
    {
        name = new Name.Builder("Catherine","Great").middleName("the").build();
        address = new Address.Builder("55","March Street","Cape Town","Western Cape","8001").build();
        salary = 30000.00f;
    }

    @Test
    public void testCreation() throws Exception
    {
        employee = new Employee.Builder(name,address,salary).build();

        Assert.assertNotNull(employee);
        Assert.assertEquals(address.getStreetName(),employee.getAddress().getStreetName());
    }

    @After
    public void tearDown() throws Exception
    {

    }
}
