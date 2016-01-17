package com.ProgrammersRUs.API;

import com.ProgrammersRUs.Domain.Orders;
import com.ProgrammersRUs.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Braedy Thebus on 01/11/2015.
 */
@RestController
@RequestMapping("/order/**")
public class OrderPage {


    @Autowired
    OrderService service;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Orders>> getOrders()
    {

        List<Orders> orderList= service.getOrders();

        if(orderList.isEmpty())
        {
            System.out.println("Orders List is empty");
            return new ResponseEntity<List<Orders>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Orders>>(orderList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> getOrder(@PathVariable("id") Long id) {
        // OrderResource hateoas;
        Orders orders = service.getOrder(id);

        if(orders == null)
        {
            return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Orders>(orders, HttpStatus.OK);
    }

    /*@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String Index()
    {
        return "View Orders";
    }

    //Get Orders
    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public List<OrderResource> getOrders()
    {
        List<OrderResource> hateoas = new ArrayList<OrderResource>();
        List<Orders> orders = service.getOrders();

        for(Orders order: orders)
        {
            OrderResource res = new OrderResource.Builder(order.getCustomerId()
                    ,order.getOrderDate())
                    .id(order.getId())
                    .build();

            Link ordersLink = new
                    Link("http://localhost:8080/order/all")
                    .withRel("order");

            res.add(ordersLink);
            hateoas.add(res);
        }

        return hateoas;
    }

    //GetOrder
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderResource getOrder(@PathVariable("id") Long id) {
        OrderResource hateoas;
        Orders order = service.getOrder(id);

        OrderResource res = new OrderResource.Builder(order.getCustomerId()
                ,order.getOrderDate())
                .id(order.getId())
                .build();

        Link ordersLink = new
                Link("http://localhost:8080/order/" + id.toString())
                .withRel("order");

        res.add(ordersLink);
        hateoas = res;


        return hateoas;
    }

    //Get Orders
    @RequestMapping(value = "/details/{customerId}", method = RequestMethod.GET)
    public List<OrderResource> getCustomerOrders(@PathVariable("customerId") Long customerId)
    {
        List<OrderResource> hateoas = new ArrayList<OrderResource>();
        List<Orders> orders = service.getCustomerOrders(customerId);

        for(Orders order: orders)
        {
            OrderResource res = new OrderResource.Builder(order.getCustomerId()
                    ,order.getOrderDate()).id(order.getId())
                    .build();

            Link ordersLink = new
                    Link("http://localhost:8080/order/details/" + customerId.toString())
                    .withRel("order");

            res.add(ordersLink);
            hateoas.add(res);
        }

        return hateoas;
    }*/
}
