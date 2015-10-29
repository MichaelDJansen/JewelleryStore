package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Item;
import com.ProgrammersRUs.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusraAdmin on 10/28/2015.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ItemServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    ItemService service;

    Long id;

    @Autowired
    private ItemRepository repository;

    Item item;

    List<Item> items = new ArrayList<>();

    private String name;
    private String description;
    private double price;
    private int quantity_on_hand;

    @Test
    public void create() throws Exception
    {

        name = "Desert gem";
        description = "Beautiful amber gem placed inside of a silver pendant";
        price = 10000.00f;
        quantity_on_hand = 4;

        item = new Item.Builder(name,description,price,quantity_on_hand).build();

        Assert.assertNotNull(item);
        Assert.assertEquals(name,item.getName());

        repository.save(item);
        id = item.getId();

        Assert.assertEquals(id, item.getId());
    }

    @Test(dependsOnMethods = "create")
    public void testGetItems() throws Exception
    {
        items = service.getItems();

        Assert.assertEquals(1, items.size());
    }

    @Test(dependsOnMethods = "create")
    public void testGetItem() throws Exception
    {
        item = service.getItem(id);

        Assert.assertEquals(id, item.getId());
    }

    @Test(dependsOnMethods = "create")
    public void testGetItemByName() throws Exception
    {
        item = service.findItemByName("Desert gem");

        Assert.assertEquals(id, item.getId());
    }

    @Test(dependsOnMethods = "create")
    public void testGetOutOfStockItems() throws Exception
    {
        items = service.findOutOfStockItems();

        Assert.assertEquals(0, items.size());
    }


    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
