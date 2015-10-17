package com.ProgrammersRUs.Repositories;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.ContactInformation;
import com.ProgrammersRUs.Domain.Name;
import com.ProgrammersRUs.Domain.Supplier;
import com.ProgrammersRUs.Factories.SupplierFactory;
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
public class SupplierRepositoryTest extends AbstractTestNGSpringContextTests{

    Long id;

    @Autowired
    private SupplierRepository repository;

    Supplier supplier;

    private String supplierName;
    private Long itemId;
    private String type;

    @Test
    public void create() throws Exception
    {

        supplierName = "Hard rock Mines";
        itemId = 50l;
        type = "Diamonds";

        supplier = new Supplier.Builder(supplierName,itemId,type).build();

        Assert.assertNotNull(supplier);
        Assert.assertEquals(type,supplier.getType());

        repository.save(supplier);
        id = supplier.getId();

        Assert.assertEquals(id, supplier.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        supplier = repository.findOne(id);

        Assert.assertEquals(id, supplier.getId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Supplier newSupplier = new Supplier.Builder(supplierName,itemId,type).build();

        repository.save(newSupplier);
        id = newSupplier.getId();
        Supplier updatedSupplier = repository.findOne(id);

        Assert.assertEquals(id, updatedSupplier.getId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        supplier = repository.findOne(id);
        repository.delete(supplier);
        supplier = repository.findOne(id);
        Assert.assertNull(supplier);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
    
}
