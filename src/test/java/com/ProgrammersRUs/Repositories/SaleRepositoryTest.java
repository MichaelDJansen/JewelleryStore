package com.ProgrammersRUs.Repositories;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.ContactInformation;
import com.ProgrammersRUs.Domain.Name;
import com.ProgrammersRUs.Domain.Sale;
import com.ProgrammersRUs.Factories.SaleFactory;
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
public class SaleRepositoryTest extends AbstractTestNGSpringContextTests{

    Long id;

    @Autowired
    private SaleRepository repository;

    Sale sale;

    private Long orderId;

    @Test
    public void create() throws Exception
    {

        orderId = 553l;

        sale = new Sale.Builder(orderId).build();

        Assert.assertNotNull(sale);
        Assert.assertEquals(orderId,sale.getOrderId());

        repository.save(sale);
        id = sale.getTransction_number();

        Assert.assertEquals(id, sale.getTransction_number());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        sale = repository.findOne(id);

        Assert.assertEquals(id, sale.getTransction_number());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Sale newSale = new Sale.Builder(664l).build();

        repository.save(newSale);
        id = newSale.getTransction_number();
        Sale updatedSale = repository.findOne(id);

        Assert.assertEquals(id, updatedSale.getTransction_number());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        sale = repository.findOne(id);
        repository.delete(sale);
        sale = repository.findOne(id);
        Assert.assertNull(sale);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
    
}
