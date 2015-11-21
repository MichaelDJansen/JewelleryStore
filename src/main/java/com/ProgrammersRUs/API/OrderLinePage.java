package com.ProgrammersRUs.API;

import com.ProgrammersRUs.Domain.OrderLine;
import com.ProgrammersRUs.Model.OrderLineResource;
import com.ProgrammersRUs.Services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Braedy Thebus on 01/11/2015.
 */
@RestController
@RequestMapping("/orderLine/**")
public class OrderLinePage {

    @Autowired
    OrderLineService service;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String Index()
    {
        return "View OrderLines";
    }

    //Get OrderLines
    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public List<OrderLineResource> getOrderLines()
    {
        List<OrderLineResource> hateoas = new ArrayList<OrderLineResource>();
        List<OrderLine> orderLines = service.getOrderLines();

        for(OrderLine orderLine: orderLines)
        {
            OrderLineResource res = new OrderLineResource.Builder(
                    orderLine.getOrderId()
                    ,orderLine.getItemId()
                    ,orderLine.getQuantity())
                    .id(orderLine.getId())
                    .build();

            Link orderLinesLink = new
                    Link("http://localhost:8080/orderLine/all")
                    .withRel("orderLine");

            res.add(orderLinesLink);
            hateoas.add(res);
        }

        return hateoas;
    }

    //GetOrderLine
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderLineResource getOrderLine(@PathVariable("id") Long id) {
        OrderLineResource hateoas;
        OrderLine orderLine = service.getOrderLine(id);

        OrderLineResource res = new OrderLineResource.Builder(
                orderLine.getOrderId()
                ,orderLine.getItemId()
                ,orderLine.getQuantity())
                .id(orderLine.getId())
                .build();

        Link orderLinesLink = new
                Link("http://localhost:8080/orderLine/" + id.toString())
                .withRel("orderLine");

        res.add(orderLinesLink);
        hateoas = res;


        return hateoas;
    }

    //Get OrderLines
    @RequestMapping(value = "/details/{orderId}", method = RequestMethod.GET)
    public List<OrderLineResource> getOrderDetails(@PathVariable("orderId") Long orderId)
    {
        List<OrderLineResource> hateoas = new ArrayList<OrderLineResource>();
        List<OrderLine> orderLines = service.getOrderDetails(orderId);

        for(OrderLine orderLine: orderLines)
        {
            OrderLineResource res = new OrderLineResource.Builder(
                    orderLine.getOrderId()
                    ,orderLine.getItemId()
                    ,orderLine.getQuantity())
                    .id(orderLine.getId())
                    .build();

            Link orderLinesLink = new
                    Link("http://localhost:8080/orderLine/details/" + orderId.toString())
                    .withRel("orderLine");

            res.add(orderLinesLink);
            hateoas.add(res);
        }

        return hateoas;
    }
}