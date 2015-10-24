package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.Employee;
import com.ProgrammersRUs.Domain.Name;
import com.ProgrammersRUs.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Braedy Thebus on 18/10/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class EmployeeServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    EmployeeService service;

    Long id;

    @Autowired
    private EmployeeRepository repository;

    Employee employee;
    List<Employee> employees = new ArrayList<>();

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
    public void testGetEmployees() throws Exception
    {
        employees = service.getEmployees();

        Assert.assertEquals(1, employees.size());
    }

    @Test(dependsOnMethods = "create")
    public void testGetEmployee() throws Exception
    {
        employee = service.getEmployee(id);

        Assert.assertEquals(id, employee.getId());
    }

    @Test(dependsOnMethods = "create")
    public void testGetEmployeeBySurname() throws Exception
    {
        employees = service.findEmployeeBySurname("Great");

        Assert.assertEquals(1, employees.size());
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }

}
