package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Orders;
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

    Orders orders;

    List<Orders> ordersList = new ArrayList<>();

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
    public void testGetOrders() throws Exception
    {
        ordersList = service.getOrders();

        Assert.assertEquals(1, ordersList.size());
    }

    @Test(dependsOnMethods = "create")
    public void testGetOrder() throws Exception
    {
        orders = service.getOrder(id);

        Assert.assertEquals(id, orders.getId());
    }

    @Test(dependsOnMethods = "create")
    public void testGetCustomerOrders() throws Exception
    {
        ordersList = service.getCustomerOrders(customerId);

        Assert.assertEquals(1, ordersList.size());
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
