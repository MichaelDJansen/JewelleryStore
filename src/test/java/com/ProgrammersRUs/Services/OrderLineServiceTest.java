package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.App;
import com.ProgrammersRUs.Domain.OrderLine;
import com.ProgrammersRUs.Repositories.OrderLineRepository;
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
public class OrderLineServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    OrderLineService service;

    Long id;

    @Autowired
    private OrderLineRepository repository;

    OrderLine orderLine;

    List<OrderLine> orderLines = new ArrayList<>();

    private Long orderId;
    private Long orderLineId;
    private int quantity;

    @Test
    public void create() throws Exception
    {

        orderId = 554l;
        orderLineId = 33l;
        quantity = 4;

        orderLine = new OrderLine.Builder(orderId,orderLineId,quantity).build();

        Assert.assertNotNull(orderLine);
        Assert.assertEquals(orderId, orderLine.getOrderId());

        repository.save(orderLine);
        id = orderLine.getId();

        Assert.assertEquals(id, orderLine.getId());
    }

    @Test(dependsOnMethods = "create")
    public void testGetOrderLines() throws Exception
    {
        orderLines = service.getOrderLines();

        Assert.assertEquals(1, orderLines.size());
    }

    @Test(dependsOnMethods = "create")
    public void testGetOrderLine() throws Exception
    {
        orderLine = service.getOrderLine(id);

        Assert.assertEquals(id, orderLine.getId());
    }

    @Test(dependsOnMethods = "create")
    public void testGetOrderDetails() throws Exception
    {
        orderLines = service.getOrderDetails(orderId);

        Assert.assertEquals(1, orderLines.size());
    }
    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
