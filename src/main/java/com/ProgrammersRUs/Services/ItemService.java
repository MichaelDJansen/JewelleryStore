package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.Domain.Item;

import java.util.List;

/**
 * Created by Michael on 17/10/2015.
 */
public interface ItemService {

    List<Item> getItems();

    Item getItem(Long Id);

    Item findItemByName(String name);

    List<Item> findOutOfStockItems();
}
