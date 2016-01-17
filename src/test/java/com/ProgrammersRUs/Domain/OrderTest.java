package com.ProgrammersRUs.Domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Michael on 16/10/2015.
 */
public class OrderTest {

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
    }

    @After
    public void tearDown() throws Exception
    {

    }
}
