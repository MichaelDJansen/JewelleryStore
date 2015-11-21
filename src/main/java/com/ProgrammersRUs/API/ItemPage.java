package com.ProgrammersRUs.API;

import com.ProgrammersRUs.Domain.Item;
import com.ProgrammersRUs.Model.ItemResource;
import com.ProgrammersRUs.Services.ItemService;
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
@RequestMapping("/item/**")
public class ItemPage {

    @Autowired
    ItemService service;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String Index()
    {
        return "View Items";
    }

    //Get Items
    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public List<ItemResource> getItems()
    {
        List<ItemResource> hateoas = new ArrayList<ItemResource>();
        List<Item> items = service.getItems();

        for(Item item: items)
        {
            ItemResource res = new ItemResource.Builder(item.getName(),
                    item.getDescription()
                    ,item.getPrice()
                    ,item.getQuantity_on_hand())
                    .build();

            Link itemsLink = new
                    Link("http://localhost:8080/item/all")
                    .withRel("item");

            res.add(itemsLink);
            hateoas.add(res);
        }

        return hateoas;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResource getItem(@PathVariable("id") Long id) {
        ItemResource hateoas;
        Item item = service.getItem(id);

        ItemResource res = new ItemResource.Builder(item.getName(),
                item.getDescription()
                ,item.getPrice()
                ,item.getQuantity_on_hand())
                .build();

        Link itemsLink = new
                Link("http://localhost:8080/item/" + id.toString())
                .withRel("item");

        res.add(itemsLink);
        hateoas = res;


        return hateoas;
    }

    //FindItemByName
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResource getItemByCellNumber(@PathVariable("name") String name) {
        ItemResource hateoas;
        Item item = service.findItemByName(name);

        ItemResource res = new ItemResource.Builder(item.getName(),
                item.getDescription()
                ,item.getPrice()
                ,item.getQuantity_on_hand())
                .build();

        Link itemsLink = new
                Link("http://localhost:8080/item/" + name)
                .withRel("item");

        res.add(itemsLink);
        hateoas = res;


        return hateoas;
    }

    @RequestMapping(value = "/OutOfStock/", method = RequestMethod.GET)
    public List<ItemResource> getOutOfStockItems()
    {
        List<ItemResource> hateoas = new ArrayList<ItemResource>();
        List<Item> items = service.findOutOfStockItems();

        for(Item item: items)
        {
            ItemResource res = new ItemResource.Builder(item.getName(),
                    item.getDescription()
                    ,item.getPrice()
                    ,item.getQuantity_on_hand())
                    .build();

            Link itemsLink = new
                    Link("http://localhost:8080/item/OutOfStock/")
                    .withRel("item");

            res.add(itemsLink);
            hateoas.add(res);
        }

        return hateoas;
    }
}
