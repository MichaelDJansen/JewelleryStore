package com.ProgrammersRUs.Domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Michael on 16/10/2015.
 */
public class OrderTest {

    Order order;

    private Long customerId;
    private Date orderDate;

    @Before
    public void setUp() throws Exception
    {
        customerId = 553l;
        orderDate = new Date(2015,12,11);
    }

    @Test
    public void testCreation() throws Exception
    {
        order = new Order.Builder(customerId,orderDate).build();
    }

    @After
    public void tearDown() throws Exception
    {

    }
}
