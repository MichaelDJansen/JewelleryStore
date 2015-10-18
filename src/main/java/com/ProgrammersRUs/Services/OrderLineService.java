package com.ProgrammersRUs.Services;


import com.ProgrammersRUs.Domain.OrderLine;

import java.util.List;

/**
 * Created by Michael on 17/10/2015.
 */
public interface OrderLineService {

    public List<OrderLine> getOrderLines();

    public OrderLine getOrderLine(Long id);

    public List<OrderLine> getOrderDetails(Long orderId);


}
