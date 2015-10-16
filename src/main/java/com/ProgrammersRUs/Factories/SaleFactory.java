package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Sale;

/**
 * Created by Michael on 16/10/2015.
 */
public class SaleFactory {
    public static Sale createSale(Long orderId){
        Sale sale = new Sale.Builder(orderId).build();

        return sale;
    }
}
