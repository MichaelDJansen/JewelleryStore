package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.Domain.Supplier;

import java.util.List;

/**
 * Created by Michael on 17/10/2015.
 */
public interface SupplierService {

    List<Supplier> getSuppliers();

    Supplier getSupplier(Long id);

    public Supplier createSupplier(Supplier supplier);

    public Supplier editSupplier(Supplier supplier);

    public void deleteSupplier(Supplier supplier);

    List<Supplier> getSuppliersByType(String type);

    Supplier findSupplierByName(String name);

    Supplier findItemsSupplier(Long id);
}
