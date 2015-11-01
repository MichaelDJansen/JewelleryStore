package com.ProgrammersRUs.API;

import com.ProgrammersRUs.Domain.Sale;
import com.ProgrammersRUs.Model.SaleResource;
import com.ProgrammersRUs.Services.SaleService;
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
@RequestMapping("/sale/**")
public class SalePage {

    @Autowired
    SaleService service;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String Index()
    {
        return "View Sales";
    }

    //Get Sales
    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public List<SaleResource> getSales()
    {
        List<SaleResource> hateoas = new ArrayList<SaleResource>();
        List<Sale> sales = service.getSales();

        for(Sale sale: sales)
        {
            SaleResource res = new SaleResource.Builder(
                    sale.getOrderId())
                    .transaction_number(sale.getTransction_number())
                    .build();

            Link salesLink = new
                    Link("http://localhost:8081/sale/all")
                    .withRel("sale");

            res.add(salesLink);
            hateoas.add(res);
        }

        return hateoas;
    }

    //GetSale
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SaleResource getSale(@PathVariable("id") Long id) {
        SaleResource hateoas;
        Sale sale = service.getSale(id);

        SaleResource res = new SaleResource.Builder(
                sale.getOrderId())
                .transaction_number(sale.getTransction_number())
                .build();

        Link salesLink = new
                Link("http://localhost:8081/sale/" + id.toString())
                .withRel("sale");

        res.add(salesLink);
        hateoas = res;


        return hateoas;
    }

    //GetSaleByOrderId
    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public SaleResource getSalesByOrder(@PathVariable("orderId") Long orderId)
    {
        SaleResource hateoas;
        Sale sale = service.getSaleByOrderId(orderId);

        SaleResource res = new SaleResource.Builder(
                sale.getOrderId())
                .transaction_number(sale.getTransction_number())
                .build();

        Link salesLink = new
                Link("http://localhost:8081/sale/" + orderId.toString())
                .withRel("sale");

        res.add(salesLink);
        hateoas = res;


        return hateoas;
    }
    
}
