package com.ProgrammersRUs.Services.Impl;

import com.ProgrammersRUs.Domain.Orders;
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


    public List<Orders> getOrders(){

        List<Orders> allOrders = new ArrayList<Orders>();

        Iterable<Orders> orders = repository.findAll();
        for(Orders order: orders)
        {
            allOrders.add(order);
        }


        return allOrders;

    }

    public Orders getOrder(Long id){

        Orders orders = repository.findOne(id);

        return orders;

    }

    public List<Orders> getCustomerOrders(Long id){

        List<Orders> matchedOrders = new ArrayList<Orders>();

        Iterable<Orders> allOrders = repository.findAll();
        for(Orders orders : allOrders)
        {
            if(orders.getCustomerId().equals(id) )
            {
                matchedOrders.add(orders);
            }
        }

        return matchedOrders;

    }
}
