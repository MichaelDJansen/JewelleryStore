package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Supplier;

/**
 * Created by Michael on 16/10/2015.
 */
public class SupplierFactory {
    public static Supplier createSupplier(String supplierName,Long itemId,String type){
        Supplier supplier = new Supplier.Builder(supplierName,itemId,type).build();

        return supplier;
    }
}
