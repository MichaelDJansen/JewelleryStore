package com.ProgrammersRUs.Services.Impl;

import com.ProgrammersRUs.Domain.Order;
import com.ProgrammersRUs.Repositories.OrderRepository;
import com.ProgrammersRUs.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusraAdmin on 10/27/2015.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;


    public List<Order> getOrders(){

        List<Order> allOrders = new ArrayList<Order>();

        Iterable<Order> orders = repository.findAll();
        for(Order order: orders)
        {
            allOrders.add(order);
        }


        return allOrders;

    }

    public Order getOrder(Long id){

        Order order = repository.findOne(id);

        return order;

    }

    public List<Order> getCustomerOrders(Long id){

        List<Order> matchedOrders = new ArrayList<Order>();

        Iterable<Order> allOrders = repository.findAll();
        for(Order order: allOrders)
        {
            if(order.getCustomerId().equals(id) )
            {
                matchedOrders.add(order);
            }
        }

        return matchedOrders;

    }
}
