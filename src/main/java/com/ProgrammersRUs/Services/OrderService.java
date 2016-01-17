package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.Domain.Orders;

import java.util.List;

/**
 * Created by Michael on 17/10/2015.
 */
public interface OrderService {

    List<Orders> getOrders();

    Orders getOrder(Long id);

    List<Orders> getCustomerOrders(Long id);

}
