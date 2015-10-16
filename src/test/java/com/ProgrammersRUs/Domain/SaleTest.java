package com.ProgrammersRUs.Domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 16/10/2015.
 */
public class SaleTest {

    Sale sale;

    private Long orderId;

    @Before
    public void setUp() throws Exception
    {
        orderId = 553l;
    }

    @Test
    public void testCreation() throws Exception
    {
        sale = new Sale.Builder(orderId).build();

        Assert.assertNotNull(sale);
        Assert.assertEquals(orderId,sale.getOrderId());
    }

    @After
    public void tearDown() throws Exception
    {

    }
}
