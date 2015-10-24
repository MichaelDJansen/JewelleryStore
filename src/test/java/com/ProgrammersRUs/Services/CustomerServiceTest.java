package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.ContactInformation;
import com.ProgrammersRUs.Domain.Customer;
import com.ProgrammersRUs.Domain.Name;
import com.ProgrammersRUs.Factories.CustomerFactory;
import com.ProgrammersRUs.Repositories.CustomerRepository;
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
public class CustomerServiceTest extends AbstractTestNGSpringContextTests{

    @Autowired
    CustomerService service;

    Long id;

    @Autowired
    private CustomerRepository repository;

    Customer customer;

    List<Customer> customers = new ArrayList<>();

    private Name name;
    private ContactInformation contactInformation;
    private Address address;

    @Test
    public void create() throws Exception
    {

        name = new Name.Builder("Michael","Jansen").build();
        contactInformation = new ContactInformation.Builder("0735589465","KarryHelgen@hotmail.com").build();
        address = new Address.Builder("55","March Street","Cape Town","Western Cape","8001").build();

        customer = CustomerFactory.createCustomer(name, contactInformation, address);

        Assert.assertNotNull(customer);
        Assert.assertEquals("0735589465",customer.getContactInformation().getCellphone());

        repository.save(customer);
        id = customer.getId();

        Assert.assertEquals(id, customer.getId());
    }

    @Test(dependsOnMethods = "create")
    public void TestGetCustomer() throws Exception
    {
        customer = service.getCustomer(id);

        Assert.assertEquals("0735589465",customer.getContactInformation().getCellphone());
    }

    @Test(dependsOnMethods = "create")
    public void TestGetCustomers() throws Exception
    {
        customers = service.getCustomers();
        Assert.assertEquals(1, customers.size());
    }


    @Test(dependsOnMethods = "create")
    public void TestGetCustomersInSameProvince() throws Exception
    {
        customers = service.customersInSameProvince("Western Cape");

        Assert.assertEquals(1, customers.size());
    }

    @Test(dependsOnMethods = "create")
    public void TestGetCustomersByCellphoneNumber() throws Exception
    {
        customer = service.findByCellphoneNumber("0735589465");

        Assert.assertEquals("0735589465",customer.getContactInformation().getCellphone());
    }
    @Test(dependsOnMethods = "create")
    public void TestGetCustomersBySurname() throws Exception
    {

        customers = service.findBySurname("Jansen");

        Assert.assertEquals("0735589465",customer.getContactInformation().getCellphone());
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }


}
