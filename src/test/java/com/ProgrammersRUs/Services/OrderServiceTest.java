package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Order;
import com.ProgrammersRUs.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yusraAdmin on 10/28/2015.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class OrderServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    OrderService service;

    Long id;

    @Autowired
    private OrderRepository repository;

    Order order;

    List<Order> orders = new ArrayList<>();

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
    public void testGetOrders() throws Exception
    {
        orders = service.getOrders();

        Assert.assertEquals(1, orders.size());
    }

    @Test(dependsOnMethods = "create")
    public void testGetOrder() throws Exception
    {
        order = service.getOrder(id);

        Assert.assertEquals(id, order.getId());
    }

    @Test(dependsOnMethods = "create")
    public void testGetCustomerOrders() throws Exception
    {
        orders = service.getCustomerOrders(customerId);

        Assert.assertEquals(1, orders.size());
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
