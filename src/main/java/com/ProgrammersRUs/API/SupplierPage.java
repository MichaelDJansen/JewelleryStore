package com.ProgrammersRUs.API;

import com.ProgrammersRUs.Domain.Supplier;
import com.ProgrammersRUs.Model.SupplierResource;
import com.ProgrammersRUs.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Braedy Thebus on 01/11/2015.
 */
@RestController
@RequestMapping("/supplier/**")
public class SupplierPage {


    @Autowired
    SupplierService service;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String Index()
    {
        return "View Suppliers";
    }

    //Get Suppliers
    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public List<SupplierResource> getSuppliers()
    {
        List<SupplierResource> hateoas = new ArrayList<SupplierResource>();
        List<Supplier> suppliers = service.getSuppliers();

        for(Supplier supplier: suppliers)
        {
            SupplierResource res = new SupplierResource.Builder(
                    supplier.getSupplierName()
                    ,supplier.getItemId()
                    ,supplier.getType())
                    .id(supplier.getId())
                    .build();

            Link suppliersLink = new
                    Link("http://localhost:8080/supplier/all")
                    .withRel("supplier");

            res.add(suppliersLink);
            hateoas.add(res);
        }

        return hateoas;
    }

    //GetSupplier
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SupplierResource getSupplier(@PathVariable("id") Long id) {
        SupplierResource hateoas;
        Supplier supplier = service.getSupplier(id);

        SupplierResource res = new SupplierResource.Builder(
                supplier.getSupplierName()
                ,supplier.getItemId()
                ,supplier.getType())
                .id(supplier.getId())
                .build();


        Link suppliersLink = new
                Link("http://localhost:8080/supplier/" + id.toString())
                .withRel("supplier");

        res.add(suppliersLink);
        hateoas = res;


        return hateoas;
    }

    //GetSuppliersByType
    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public List<SupplierResource> getSuppliers(@PathVariable("type")String type)
    {
        List<SupplierResource> hateoas = new ArrayList<SupplierResource>();
        List<Supplier> suppliers = service.getSuppliersByType(type);

        for(Supplier supplier: suppliers)
        {
            SupplierResource res = new SupplierResource.Builder(
                    supplier.getSupplierName()
                    ,supplier.getItemId()
                    ,supplier.getType())
                    .id(supplier.getId())
                    .build();

            Link suppliersLink = new
                    Link("http://localhost:8080/supplier/type/" + type)
                    .withRel("supplier");

            res.add(suppliersLink);
            hateoas.add(res);
        }

        return hateoas;
    }

    //GetSupplier
    @RequestMapping(value = "name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SupplierResource findSupplierByName(@PathVariable("name") String name) {
        SupplierResource hateoas;
        Supplier supplier = service.findSupplierByName(name);

        SupplierResource res = new SupplierResource.Builder(
                supplier.getSupplierName()
                ,supplier.getItemId()
                ,supplier.getType())
                .id(supplier.getId())
                .build();


        Link suppliersLink = new
                Link("http://localhost:8080/supplier/name/" + name)
                .withRel("supplier");

        res.add(suppliersLink);
        hateoas = res;


        return hateoas;
    }

    //GetSupplier
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SupplierResource getItemSupplier(@PathVariable("id") Long id) {
        SupplierResource hateoas;
        Supplier supplier = service.getSupplier(id);

        SupplierResource res = new SupplierResource.Builder(
                supplier.getSupplierName()
                ,supplier.getItemId()
                ,supplier.getType())
                .id(supplier.getId())
                .build();


        Link suppliersLink = new
                Link("http://localhost:8080/supplier/itemId/" + id.toString())
                .withRel("supplier");

        res.add(suppliersLink);
        hateoas = res;


        return hateoas;
    }
}
