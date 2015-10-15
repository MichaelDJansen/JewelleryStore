package com.ProgrammersRUs.Domain;

/**
 * Created by Michael on 14/10/2015.
 */
public class Item {

    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity_on_hand;

     /*
    public Supplier(Builder builder){}

    public class Builder{

        public Builder(){}

        public Builder copy(){}

        public Supplier build(){}
    }
    */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity_on_hand() {
        return quantity_on_hand;
    }
}
