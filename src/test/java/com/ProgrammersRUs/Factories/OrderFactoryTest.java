package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Orders;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Michael on 17/10/2015.
 */
public class OrderFactoryTest {

    Orders orders;

    private Long customerId;
    private String orderDate;

    @Before
    public void setUp() throws Exception
    {
        customerId = 553l;
        orderDate = "2015,12,11";
    }

    @Test
    public void testCreation() throws Exception
    {
        orders = new Orders.Builder(customerId,orderDate).build();

        Assert.assertNotNull(orders);
        Assert.assertEquals(customerId, orders.getCustomerId());

    }

    @After
    public void tearDown() throws Exception
    {

    }

}
