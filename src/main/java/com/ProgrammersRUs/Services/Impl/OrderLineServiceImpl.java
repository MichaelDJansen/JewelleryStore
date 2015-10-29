package com.ProgrammersRUs.Services.Impl;

import com.ProgrammersRUs.Domain.OrderLine;
import com.ProgrammersRUs.Repositories.OrderLineRepository;
import com.ProgrammersRUs.Services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusraAdmin on 10/27/2015.
 */
@Service
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    OrderLineRepository repository;

    public List<OrderLine> getOrderLines(){

        List<OrderLine> allOrderLines = new ArrayList<OrderLine>();

        Iterable<OrderLine> orderLines = repository.findAll();
        for(OrderLine orderLine: orderLines)
        {
            allOrderLines.add(orderLine);
        }


        return allOrderLines;

    }

    public OrderLine getOrderLine(Long id){

        OrderLine orderLine = repository.findOne(id);

        return orderLine;

    }

    public List<OrderLine> getOrderDetails(Long orderId){

        List<OrderLine> matchedOrderLines = new ArrayList<>();

        Iterable<OrderLine> allOrderLines = repository.findAll();
        for(OrderLine orderLine: allOrderLines)
        {
            if(orderLine.getOrderId().equals(orderId))
            {
                matchedOrderLines.add(orderLine);
            }
        }

        return matchedOrderLines;


    }
}
