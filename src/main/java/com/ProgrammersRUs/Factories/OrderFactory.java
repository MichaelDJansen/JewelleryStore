package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Orders;

import java.util.Date;

/**
 * Created by Michael on 16/10/2015.
 */
public class OrderFactory {
    public static Orders createOrder(Long customerId,String orderDate){
        Orders orders = new Orders.Builder(customerId,orderDate).build();

        return orders;
    }
}
