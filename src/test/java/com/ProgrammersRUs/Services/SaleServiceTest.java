package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.Sale;
import com.ProgrammersRUs.Repositories.SaleRepository;
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
public class SaleServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    SaleService service;

    Long id;

    @Autowired
    private SaleRepository repository;

    Sale sale;

    List<Sale> sales = new ArrayList<>();

    private Long saleId;

    @Test
    public void create() throws Exception
    {

        saleId = 553l;

        sale = new Sale.Builder(saleId).build();

        Assert.assertNotNull(sale);
        Assert.assertEquals(saleId,sale.getOrderId());

        repository.save(sale);
        id = sale.getTransction_number();

        Assert.assertEquals(id, sale.getTransction_number());
    }

    @Test(dependsOnMethods = "create")
    public void testGetSales() throws Exception
    {
        sales = service.getSales();

        Assert.assertEquals(1, sales.size());
    }

    @Test(dependsOnMethods = "create")
    public void testGetSale() throws Exception
    {
        sale = service.getSale(id);

        Assert.assertEquals(id, sale.getTransction_number());
    }

    @Test(dependsOnMethods = "create")
    public void testGetSaleByOrderId() throws Exception
    {
        sale = service.getSaleByOrderId(saleId);

        Assert.assertEquals(id, sale.getTransction_number());
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
