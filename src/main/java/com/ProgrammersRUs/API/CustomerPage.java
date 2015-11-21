package com.ProgrammersRUs.API;

import com.ProgrammersRUs.Domain.Customer;
import com.ProgrammersRUs.Model.CustomerResource;
import com.ProgrammersRUs.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/customer/**")
public class CustomerPage {
    
    @Autowired
    CustomerService service;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String Index()
    {
        return "View Customers";
    }

    //Get Customers
    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public List<CustomerResource> getCustomers()
    {
        List<CustomerResource> hateoas = new ArrayList<CustomerResource>();
        List<Customer> customers = service.getCustomers();

        for(Customer customer: customers)
        {
                CustomerResource res = new CustomerResource.Builder(
                         customer.getName()
                        ,customer.getContactInformation())
                        .address(customer.getAddress())
                        .id(customer.getId())
                        .build();

                Link customersLink = new
                        Link("http://localhost:8080/customer/all")
                        .withRel("customer");

                res.add(customersLink);
                hateoas.add(res);
        }

        return hateoas;
    }

    //GetCustomer
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResource getCustomer(@PathVariable("id") Long id) {
        CustomerResource hateoas;
        Customer customer = service.getCustomer(id);

            CustomerResource res = new CustomerResource.Builder(
                    customer.getName()
                    ,customer.getContactInformation())
                    .address(customer.getAddress())
                    .id(customer.getId())
                    .build();

            Link customersLink = new
                    Link("http://localhost:8080/customer/" + id.toString())
                    .withRel("customer");

            res.add(customersLink);
            hateoas = res;


        return hateoas;
    }

    //GetByProvince
    @RequestMapping(value = "/province/{province}", method = RequestMethod.GET)
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
    }

    //CustomerByCellphoneNumber
    @RequestMapping(value = "/cellphone/{cellphone}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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
    }

    //CustomersBySurname
    @RequestMapping(value = "/surname/{surname}", method = RequestMethod.GET)
    public List<CustomerResource> getCustomersBySurname(@PathVariable("surname") String surname) {
        List<CustomerResource> hateoas = new ArrayList<CustomerResource>();
        List<Customer> customers = service.findBySurname(surname);

        for (Customer customer : customers) {
            CustomerResource res = new CustomerResource.Builder(
                    customer.getName()
                    , customer.getContactInformation())
                    .address(customer.getAddress())
                    .id(customer.getId())
                    .build();

            Link customersLink = new
                    Link("http://localhost:8080/customer/surname/" + surname)
                    .withRel("customer");

            res.add(customersLink);
            hateoas.add(res);

        }
        return hateoas;
    }
}
