package com.ProgrammersRUs.Repositories;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.ContactInformation;
import com.ProgrammersRUs.Domain.Name;
import com.ProgrammersRUs.Domain.Order;
import com.ProgrammersRUs.Factories.OrderFactory;
import org.junit.AfterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
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

    Order order;

    private Long customerId;
    private Date orderDate;

    @Test
    public void create() throws Exception
    {

        customerId = 553l;
        orderDate = new Date(2015,12,11);

        order = new Order.Builder(customerId,orderDate).build();

        Assert.assertNotNull(order);
        Assert.assertEquals(customerId,order.getCustomerId());

        repository.save(order);
        id = order.getId();

        Assert.assertEquals(id, order.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        order = repository.findOne(id);

        Assert.assertEquals(id, order.getId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Order newOrder = new Order.Builder(336l,orderDate).build();

        repository.save(newOrder);
        id = newOrder.getId();
        Order updatedOrder = repository.findOne(id);

        Assert.assertEquals(id, updatedOrder.getId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        order = repository.findOne(id);
        repository.delete(order);
        order = repository.findOne(id);
        Assert.assertNull(order);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }


}
