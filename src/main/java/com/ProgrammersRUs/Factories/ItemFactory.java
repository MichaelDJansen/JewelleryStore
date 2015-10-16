package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Item;

/**
 * Created by Michael on 16/10/2015.
 */
public class ItemFactory {

    public static Item createItem(String name,String description,double price,int quantity_on_hand){
        Item item = new Item.Builder(name, description, price, quantity_on_hand).build();

        return item;
    }
}
