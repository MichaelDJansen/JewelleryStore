package com.ProgrammersRUs.API;

import com.ProgrammersRUs.Domain.Item;
import com.ProgrammersRUs.Model.ItemResource;
import com.ProgrammersRUs.Services.ItemService;
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
@RequestMapping("/item/**")
public class ItemPage {

    @Autowired
    ItemService service;

   /* @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String Index()
    {
        return "View Items";
    }*/

    //Get Items
    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getItems()
    {

        List<Item> itemList= service.getItems();

        if(itemList.isEmpty())
        {
            return new ResponseEntity<List<Item>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Item>>(itemList, HttpStatus.OK);

        /*for(Item item: items)
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

        return hateoas;*/
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItem(@PathVariable("id") Long id) {
       // ItemResource hateoas;
        Item item = service.getItem(id);

        if(item == null)
        {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Item>(item, HttpStatus.OK);

        /*ItemResource res = new ItemResource.Builder(item.getName(),
                item.getDescription()
                ,item.getPrice()
                ,item.getQuantity_on_hand())
                .build();

        Link itemsLink = new
                Link("http://localhost:8080/item/" + id.toString())
                .withRel("item");

        res.add(itemsLink);
        hateoas = res;


        return hateoas;*/
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createItem(@RequestBody Item item, UriComponentsBuilder ucBuilder)
    {
        service.createItem(item);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/all").buildAndExpand(item.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Item> updateItem(@PathVariable("id") long id, @RequestBody Item item) {

        Item item1 = service.getItem(id);

        if (item1 ==null) {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        Item newItem = new Item.Builder(item1.getName(), item1.getDescription(),item1.getPrice(), item1.getQuantity_on_hand()).build();
        service.editItem(newItem);
        return new ResponseEntity<Item>(newItem, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Item> deleteItem(@PathVariable("id") long id, @RequestBody Item item) {

        Item item1 = service.getItem(id);

        if (item1 == null) {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        service.deleteItem(item);
        return new ResponseEntity<Item>(HttpStatus.OK);
    }

    //FindItemByName
    /*@RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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
    }*/
}
