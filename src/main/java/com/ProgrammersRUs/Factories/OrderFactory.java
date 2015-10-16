package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Order;

import java.util.Date;

/**
 * Created by Michael on 16/10/2015.
 */
public class OrderFactory {
    public static Order createOrder(Long customerId,Date orderDate){
        Order order = new Order.Builder(customerId,orderDate).build();

        return order;
    }
}
