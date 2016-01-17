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
 * Created by yusraAdmin on 10/28/2015.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CustomerServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    CustomerService service;

    Long id;

    @Autowired
    private CustomerRepository repository;

    Customer customer;

    List<Customer> customers = new ArrayList<>();

    private Name name;
    private String companyName;
    private ContactInformation contactInformation;
    private String address;
    private String username;
    private String password;

    @Test
    public void create() throws Exception
    {

        name = new Name.Builder("Michael","Jansen").build();
        companyName  = "ABC Corp.";
        contactInformation = new ContactInformation.Builder("0735589465","KarryHelgen@hotmail.com").build();
        address = "55 March Street Cape Town Western Cape 8001";
        username = "Mike435";
        password = "Iam_Mike";

        customer = CustomerFactory.createCustomer(name, companyName,contactInformation, address, username, password);

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


    /*@Test(dependsOnMethods = "create")
    public void TestGetCustomersInSameProvince() throws Exception
    {
        customers = service.customersInSameProvince("Western Cape");

        Assert.assertEquals(1, customers.size());
    }*/

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
