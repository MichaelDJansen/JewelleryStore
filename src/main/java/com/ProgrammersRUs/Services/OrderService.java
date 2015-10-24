package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.Domain.Order;

import java.util.List;

/**
 * Created by Braedy	Thebus on 17/10/2015.
 */
public interface OrderService {

    List<Order> getOrders();

    Order getOrder(Long id);

    List<Order> getCustomerOrders(Long id);

}
