package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Supplier;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 17/10/2015.
 */
public class SupplierFactoryTest {

    Supplier supplier;

    private String supplierName;
    private Long itemId;
    private String type;

    @Before
    public void setUp() throws Exception
    {
        supplierName = "Hard rock Mines";
        itemId = 50l;
        type = "Diamonds";
    }

    @Test
    public void testCreation() throws Exception
    {
        supplier = new Supplier.Builder(supplierName,itemId,type).build();

        Assert.assertNotNull(supplier);
        Assert.assertEquals(type,supplier.getType());
    }

    @After
    public void tearDown() throws Exception
    {

    }

}
