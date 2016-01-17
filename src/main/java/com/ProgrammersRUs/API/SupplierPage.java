package com.ProgrammersRUs.API;

import com.ProgrammersRUs.Domain.Supplier;
import com.ProgrammersRUs.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public ResponseEntity<List<Supplier>> getSuppliers()
    {

        List<Supplier> supplierList= service.getSuppliers();

        if(supplierList.isEmpty())
        {
            return new ResponseEntity<List<Supplier>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Supplier>>(supplierList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Supplier> getSupplier(@PathVariable("id") Long id) {

        Supplier supplier = service.getSupplier(id);

        if(supplier == null)
        {
            return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createSupplier(@RequestBody Supplier supplier, UriComponentsBuilder ucBuilder)
    {
        service.createSupplier(supplier);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/all").buildAndExpand(supplier.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Supplier> updateSupplier(@PathVariable("id") long id, @RequestBody Supplier supplier) {

        if (supplier ==null) {

            return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
        }
        service.editSupplier(supplier);
        return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable("id") long id) {

        Supplier supplier1 = service.getSupplier(id);

        if (supplier1 == null) {
            return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
        }

        service.deleteSupplier(supplier1);
        return new ResponseEntity<Supplier>(HttpStatus.OK);
    }

}
