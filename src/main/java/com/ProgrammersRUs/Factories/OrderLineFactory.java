package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.OrderLine;

/**
 * Created by Michael on 16/10/2015.
 */
public class OrderLineFactory {

    public static OrderLine createOrderLine(Long orderId,Long itemId,int quantity){
        OrderLine orderLine = new OrderLine.Builder(orderId,itemId,quantity).build();

        return orderLine;
    }
}
