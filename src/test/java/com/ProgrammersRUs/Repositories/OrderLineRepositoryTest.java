package com.ProgrammersRUs.Repositories;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.ContactInformation;
import com.ProgrammersRUs.Domain.Name;
import com.ProgrammersRUs.Domain.OrderLine;
import com.ProgrammersRUs.Factories.OrderLineFactory;
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
public class OrderLineRepositoryTest extends AbstractTestNGSpringContextTests{


    Long id;

    @Autowired
    private OrderLineRepository repository;

    OrderLine orderLine;

    private Long orderId;
    private Long itemId;
    private int quantity;

    @Test
    public void create() throws Exception
    {

        orderId = 554l;
        itemId = 33l;
        quantity = 4;

        orderLine = new OrderLine.Builder(orderId,itemId,quantity).build();

        Assert.assertNotNull(orderLine);
        Assert.assertEquals(orderId, orderLine.getOrderId());

        repository.save(orderLine);
        id = orderLine.getId();

        Assert.assertEquals(id, orderLine.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        orderLine = repository.findOne(id);

        Assert.assertEquals(id, orderLine.getId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        OrderLine newOrderLine = new OrderLine.Builder(orderId,itemId,quantity).build();

        repository.save(newOrderLine);
        id = newOrderLine.getId();
        OrderLine updatedOrderLine = repository.findOne(id);

        Assert.assertEquals(id, updatedOrderLine.getId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        orderLine = repository.findOne(id);
        repository.delete(orderLine);
        orderLine = repository.findOne(id);
        Assert.assertNull(orderLine);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }


}
