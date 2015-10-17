package com.ProgrammersRUs.Repositories;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.ContactInformation;
import com.ProgrammersRUs.Domain.Employee;
import com.ProgrammersRUs.Domain.Name;
import com.ProgrammersRUs.Factories.EmployeeFactory;
import org.junit.AfterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Michael on 17/10/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class EmployeeRepositoryTest extends AbstractTestNGSpringContextTests {

    Long id;

    @Autowired
    private EmployeeRepository repository;

    Employee employee;

    private Name name;
    private Address address;
    private float salary;

    @Test
    public void create() throws Exception
    {

        name = new Name.Builder("Catherine","Great").middleName("the").build();
        address = new Address.Builder("55","March Street","Cape Town","Western Cape","8001").build();
        salary = 30000.00f;

        employee = new Employee.Builder(name,address,salary).build();

        Assert.assertNotNull(employee);
        Assert.assertEquals(address.getStreetName(),employee.getAddress().getStreetName());

        repository.save(employee);
        id = employee.getId();

        Assert.assertEquals(id, employee.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        employee = repository.findOne(id);

        Assert.assertEquals(id, employee.getId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        address = new Address.Builder("53","March Street","Cape Town","Western Cape","8001").build();

        Employee newEmployee = new Employee.Builder(name,address,salary).build();

        repository.save(newEmployee);
        id = newEmployee.getId();
        Employee updatedEmployee = repository.findOne(id);

        Assert.assertEquals(id, updatedEmployee.getId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        employee = repository.findOne(id);
        repository.delete(employee);
        employee = repository.findOne(id);
        Assert.assertNull(employee);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }


}
