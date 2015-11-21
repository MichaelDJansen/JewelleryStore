package com.ProgrammersRUs.Repositories;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.ContactInformation;
import com.ProgrammersRUs.Domain.Customer;
import com.ProgrammersRUs.Domain.Name;
import com.ProgrammersRUs.Factories.CustomerFactory;
import org.testng.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by Michael on 17/10/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CustomerRepositoryTest extends AbstractTestNGSpringContextTests {


    Long id;

    @Autowired
    private CustomerRepository repository;

    Customer customer;

    private Name name;
    private ContactInformation contactInformation;
    private Address address;
    private String username;
    private String password;

    @Test
    public void create() throws Exception
    {

        name = new Name.Builder("Michael","Jansen").build();
        contactInformation = new ContactInformation.Builder("0735589465","KarryHelgen@hotmail.com").build();
        address = new Address.Builder("55","March Street","Cape Town","Western Cape","8001").build();
        username = "Mike435";
        password = "Iam_Mike";

        customer = CustomerFactory.createCustomer(name, contactInformation, address, username, password);

        Assert.assertNotNull(customer);
        Assert.assertEquals("0735589465",customer.getContactInformation().getCellphone());

        repository.save(customer);
        id = customer.getId();

        Assert.assertEquals(id, customer.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        customer = repository.findOne(id);

        Assert.assertEquals(id, customer.getId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        address = new Address.Builder("53","March Street","Cape Town","Western Cape","8001").build();

        Customer newCustomer = CustomerFactory.createCustomer(name, contactInformation, address, username, password);

        repository.save(newCustomer);
        id = newCustomer.getId();
        Customer updatedCustomer = repository.findOne(id);

        Assert.assertEquals(id, updatedCustomer.getId());
    }

   /* @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        customer = repository.findOne(id);
        repository.delete(customer);
        customer = repository.findOne(id);
        Assert.assertNull(customer);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }*/

}
