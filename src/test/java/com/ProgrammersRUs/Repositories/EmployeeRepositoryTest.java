package com.ProgrammersRUs.Repositories;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.ContactInformation;
import com.ProgrammersRUs.Domain.Employee;
import com.ProgrammersRUs.Domain.Name;
import com.ProgrammersRUs.Factories.EmployeeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
    private String username;
    private String password;

    @Test
    public void create() throws Exception
    {

        name = new Name.Builder("Catherine","Great").middleName("the").build();
        username = "Mike101";
        password = "123456";

        employee = new Employee.Builder(name,username,password).build();

        Assert.assertNotNull(employee);
        Assert.assertEquals(name.getFirstName(),employee.getName().getFirstName() );

        repository.save(employee);
        id = employee.getId();

        Assert.assertEquals(id, employee.getId());
    }

    /*@Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        employee = repository.findOne(id);

        Assert.assertEquals(id, employee.getId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        name = new Name.Builder("Catherine","Jansen").middleName("the").build();

        Employee newEmployee = new Employee.Builder(name,username,password).build();

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

*/


}
