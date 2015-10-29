package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Supplier;
import com.ProgrammersRUs.Repositories.SupplierRepository;
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
public class SupplierServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    SupplierService service;

    Long id;

    @Autowired
    private SupplierRepository repository;

    Supplier supplier;
    List<Supplier> suppliers = new ArrayList<>();
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
    public void testGetSuppliers() throws Exception
    {
        suppliers = service.getSuppliers();

        Assert.assertEquals(1, suppliers.size());
    }

    @Test(dependsOnMethods = "create")
    public void testGetSupplier() throws Exception
    {
        supplier = service.getSupplier(id);

        Assert.assertEquals(id, supplier.getId());
    }

    @Test(dependsOnMethods = "create")
    public void testGetSuppliersByType() throws Exception
    {
        suppliers = service.getSuppliersByType("Diamonds");

        Assert.assertEquals(1, suppliers.size());
    }

    @Test(dependsOnMethods = "create")
    public void testGetSupplierByName() throws Exception
    {
        supplier = service.findSupplierByName("Hard rock Mines");

        Assert.assertEquals(id, supplier.getId());
    }

    @Test(dependsOnMethods = "create")
    public void testGetItemSupplier() throws Exception
    {
        supplier = service.findItemsSupplier(itemId);

        Assert.assertEquals(id, supplier.getId());
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
