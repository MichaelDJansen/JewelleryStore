package com.ProgrammersRUs.Services.Impl;

import com.ProgrammersRUs.Domain.Sale;
import com.ProgrammersRUs.Repositories.SaleRepository;
import com.ProgrammersRUs.Services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Braedy Thebus on 18/10/2015.
 */
@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    SaleRepository repository;


    public List<Sale> getSales(){

        List<Sale> allSales = new ArrayList<Sale>();

        Iterable<Sale> sales = repository.findAll();
        for(Sale sale: sales)
        {
            allSales.add(sale);
        }

        return allSales;
        
    }

    public Sale getSale(Long id){

        Sale sale = repository.findOne(id);

        return sale;
        
    }

    public Sale getSaleByOrderId(Long id){

        List<Sale> matchedSales = new ArrayList<Sale>();
        Sale foundSale = null;
        Iterable<Sale> allSales = repository.findAll();
        for(Sale sale: allSales)
        {
            if(sale.getOrderId().equals(id))
            {
                foundSale = sale;
                break;
            }
        }

        return foundSale;

    }
    
}
