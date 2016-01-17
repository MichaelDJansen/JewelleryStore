package com.ProgrammersRUs.Services.Impl;

import com.ProgrammersRUs.Domain.Supplier;
import com.ProgrammersRUs.Repositories.SupplierRepository;
import com.ProgrammersRUs.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusraAdmin on 10/27/2015.
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository repository;

    public List<Supplier> getSuppliers(){

        List<Supplier> allSuppliers = new ArrayList<Supplier>();

        Iterable<Supplier> suppliers = repository.findAll();
        for(Supplier supplier: suppliers)
        {
            allSuppliers.add(supplier);
        }


        return allSuppliers;


    }

    public Supplier getSupplier(Long id){

        Supplier supplier = repository.findOne(id);

        return supplier;

    }

    public Supplier createSupplier(Supplier supplier)
    {
        return repository.save(supplier);
    }

    public Supplier editSupplier(Supplier supplier)
    {
        return repository.save(supplier);
    }

    public void deleteSupplier(Supplier supplier)
    {
        repository.delete(supplier);
    }

    public List<Supplier> getSuppliersByType(String type){

        List<Supplier> matchedSuppliers = new ArrayList<Supplier>();

        Iterable<Supplier> allSuppliers = repository.findAll();
        for(Supplier supplier: allSuppliers)
        {
            if(supplier.getType().equalsIgnoreCase(type))
            {
                matchedSuppliers.add(supplier);
            }
        }

        return matchedSuppliers;

    }

    public Supplier findSupplierByName(String name){

        Supplier foundSupplier = null;

        Iterable<Supplier> allSuppliers = repository.findAll();
        for(Supplier supplier: allSuppliers)
        {
            if(supplier.getSupplierName().equalsIgnoreCase(name))
            {
                foundSupplier = supplier;
                break;
            }
        }

        return foundSupplier;

    }

    public Supplier findItemsSupplier(Long id){

        Supplier foundSupplier = null;
        Iterable<Supplier> allSuppliers = repository.findAll();
        for(Supplier supplier: allSuppliers)
        {
            if(supplier.getItemId().equals(id))
            {
                foundSupplier = supplier;
                break;
            }
        }

        return foundSupplier;

    }
}
