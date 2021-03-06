package com.ProgrammersRUs.API;

import com.ProgrammersRUs.Domain.Customer;
import com.ProgrammersRUs.Factories.CustomerFactory;
import com.ProgrammersRUs.Model.CustomerResource;
import com.ProgrammersRUs.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
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
@RequestMapping("/customer/**")
public class CustomerPage {
    
    @Autowired
    CustomerService service;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomers()
    {
        List<Customer> customerList = service.getCustomers();

        if(customerList.isEmpty())
        {
            return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
    }

    //GetCustomer
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {

        Customer customer = service.getCustomer(id);

        if(customer == null)
        {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);

    }

    //GetByProvince
   /* @RequestMapping(value = "/province/{province}", method = RequestMethod.GET)
    public List<CustomerResource> getCustomersInProvince(@PathVariable("province") String province) {
        List<CustomerResource> hateoas = new ArrayList<CustomerResource>();
        List<Customer> customers = service.customersInSameProvince(province);

        for(Customer customer: customers)
        {
            CustomerResource res = new CustomerResource.Builder(
                    customer.getName()
                    ,customer.getContactInformation())
                    .address(customer.getAddress())
                    .id(customer.getId())
                    .build();

            Link customersLink = new
                    Link("http://localhost:8080/customer/province/" + province)
                    .withRel("customer");

            res.add(customersLink);
            hateoas.add(res);
        }

        return hateoas;
    }*/

    //CustomerByCellphoneNumber
    /*@RequestMapping(value = "/cellphone/{cellphone}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResource getCustomerByCellNumber(@PathVariable("cellphone") String cellphone) {
        CustomerResource hateoas;
        Customer customer = service.findByCellphoneNumber(cellphone);

        CustomerResource res = new CustomerResource.Builder(
                customer.getName()
                ,customer.getContactInformation())
                .address(customer.getAddress())
                .id(customer.getId())
                .build();

        Link customersLink = new
                Link("http://localhost:8080/customer/cellphone/" + cellphone)
                .withRel("customer");

        res.add(customersLink);
        hateoas = res;


        return hateoas;
    }*/

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomersByName(@PathVariable("name") String name) {
        List<Customer> customers = service.findByName(name);

        List<Customer> CustomerList= service.findByName(name);

        if(CustomerList.isEmpty())
        {
            return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Customer>>(CustomerList, HttpStatus.OK);

    }

    //CustomersBySurname
    @RequestMapping(value = "/surname/{surname}", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomersBySurname(@PathVariable("surname") String surname) {
        List<Customer> customers = service.findBySurname(surname);

        List<Customer> CustomerList= service.findBySurname(surname);

        if(CustomerList.isEmpty())
        {
            return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Customer>>(CustomerList, HttpStatus.OK);

    }

    @RequestMapping(value = "/company/{company}", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomersByCompany(@PathVariable("company") String company) {
        List<Customer> customers = service.findByCompany(company);

        List<Customer> CustomerList= service.findByCompany(company);

        if(CustomerList.isEmpty())
        {
            return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Customer>>(CustomerList, HttpStatus.OK);

    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder)
    {
        service.createCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/all").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {

        //Customer cust = service.getCustomer(id);

        if (customer==null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        Customer newCustomer = new Customer.Builder(customer.getName(),customer.getContactInformation()).address(customer.getAddress()).build();
        service.editCustomer(newCustomer);
        return new ResponseEntity<Customer>(newCustomer, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id, @RequestBody Customer cust) {

        Customer customer = service.getCustomer(id);

        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        service.deleteCustomer(customer);
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }
}
