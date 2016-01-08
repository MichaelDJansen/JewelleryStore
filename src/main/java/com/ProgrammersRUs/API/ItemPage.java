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

    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getItems()
    {

        List<Item> itemList= service.getItems();

        if(itemList.isEmpty())
        {
            return new ResponseEntity<List<Item>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Item>>(itemList, HttpStatus.OK);
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

        if (item ==null) {

            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
        service.editItem(item);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Item> deleteItem(@PathVariable("id") long id) {

        Item item1 = service.getItem(id);

        if (item1 == null) {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        service.deleteItem(item1);
        return new ResponseEntity<Item>(HttpStatus.OK);
    }
}
