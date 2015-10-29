package com.ProgrammersRUs.Services.Impl;

import com.ProgrammersRUs.Domain.Item;
import com.ProgrammersRUs.Repositories.ItemRepository;
import com.ProgrammersRUs.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusraAdmin on 10/27/2015.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository repository;

    public List<Item> getItems(){

        List<Item> allItems = new ArrayList<Item>();

        Iterable<Item> items = repository.findAll();
        for(Item item: items)
        {
            allItems.add(item);
        }

        return allItems;

    }

    public Item getItem(Long Id){

        Item item = repository.findOne(Id);

        return item;
    }

    public Item findItemByName(String name){

        Item foundItem = null;

        Iterable<Item> allItems = repository.findAll();
        for(Item item: allItems)
        {
            if(item.getName().equalsIgnoreCase(name))
            {
                foundItem = item;
                break;
            }
        }

        return foundItem;

    }

    public List<Item> findOutOfStockItems(){

        List<Item> OOSItems = new ArrayList<Item>();

        Iterable<Item> allItems = repository.findAll();
        for(Item item: allItems)
        {
            if(item.getQuantity_on_hand() == 0)
            {
                OOSItems.add(item);
            }
        }

        return OOSItems;

    }

}
