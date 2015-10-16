package com.ProgrammersRUs.Domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 16/10/2015.
 */
public class OrderLineTest {

    OrderLine orderLine;

    private Long orderId;
    private Long itemId;
    private int quantity;

    @Before
    public void setUp() throws Exception
    {
        orderId = 554l;
        itemId = 33l;
        quantity = 4;
    }

    @Test
    public void testCreation() throws Exception
    {
        orderLine = new OrderLine.Builder(orderId,itemId,quantity).build();

        Assert.assertNotNull(orderLine);
        Assert.assertEquals(orderId,orderLine.getOrderId());
    }

    @After
    public void tearDown() throws Exception
    {

    }
}
