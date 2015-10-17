package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Item;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 17/10/2015.
 */
public class ItemFactoryTest {

    Item item;

    private String name;
    private String description;
    private double price;
    private int quantity_on_hand;


    @Before
    public void setUp() throws Exception
    {
        name = "Desert gem";
        description = "Beautiful amber gem placed inside of a silver pendant";
        price = 10000.00f;
        quantity_on_hand = 4;
    }

    @Test
    public void testCreation() throws Exception
    {
        item = new Item.Builder(name,description,price,quantity_on_hand).build();

        Assert.assertNotNull(item);
        Assert.assertEquals(name,item.getName());
    }

    @After
    public void tearDown() throws Exception
    {

    }

}
