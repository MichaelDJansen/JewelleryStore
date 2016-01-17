package com.ProgrammersRUs.Repositories;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by Michael on 17/10/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class OrderRepositoryTest extends AbstractTestNGSpringContextTests{


    Long id;

    @Autowired
    private OrderRepository repository;

    Orders orders;

    private Long customerId;
    private String orderDate;

    @Test
    public void create() throws Exception
    {

        customerId = 553l;
        orderDate = "2015,12,11";

        orders = new Orders.Builder(customerId,orderDate).build();

        Assert.assertNotNull(orders);
        Assert.assertEquals(customerId, orders.getCustomerId());

        repository.save(orders);
        id = orders.getId();

        Assert.assertEquals(id, orders.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        orders = repository.findOne(id);

        Assert.assertEquals(id, orders.getId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Orders newOrder = new Orders.Builder(336l,orderDate).build();

        repository.save(newOrder);
        id = newOrder.getId();
        Orders updatedOrders = repository.findOne(id);

        Assert.assertEquals(id, updatedOrders.getId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        orders = repository.findOne(id);
        repository.delete(orders);
        orders = repository.findOne(id);
        Assert.assertNull(orders);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }


}
