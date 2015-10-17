package com.ProgrammersRUs.Repositories;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.ContactInformation;
import com.ProgrammersRUs.Domain.Item;
import com.ProgrammersRUs.Domain.Name;
import com.ProgrammersRUs.Factories.ItemFactory;
import org.junit.AfterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Michael on 17/10/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ItemRepositoryTest  extends AbstractTestNGSpringContextTests {


    Long id;

    @Autowired
    private ItemRepository repository;

    Item item;

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
    public void read() throws Exception
    {
        item = repository.findOne(id);

        Assert.assertEquals(id, item.getId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Item newItem = new Item.Builder("Sub Sahara Gem",description,price,quantity_on_hand).build();

        repository.save(newItem);
        id = newItem.getId();
        Item updatedItem = repository.findOne(id);

        Assert.assertEquals(id, updatedItem.getId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        item = repository.findOne(id);
        repository.delete(item);
        item = repository.findOne(id);
        Assert.assertNull(item);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }


}
