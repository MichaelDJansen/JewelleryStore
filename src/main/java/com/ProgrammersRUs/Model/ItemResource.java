package com.ProgrammersRUs.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by yusraAdmin on 10/29/2015.
 */
public class ItemResource extends ResourceSupport {

    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity_on_hand;

    protected ItemResource(){}

    public ItemResource(Builder builder){
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.quantity_on_hand = builder.quantity_on_hand;
    }

    public static class Builder{

        private Long id;
        private String name;
        private String description;
        private double price;
        private int quantity_on_hand;

        public Builder(String name,String description,double price,int quantity_on_hand){
            this.name = name;
            this.description = description;
            this.price = price;
            this.quantity_on_hand = quantity_on_hand;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder price(float price){
            this.price = price;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder quantity_on_hand(int quantity_on_hand){
            this.quantity_on_hand = quantity_on_hand;
            return this;
        }

        public Builder copy(ItemResource item){
            this.name = item.name;
            this.description = item.description;
            this.price = item.price;
            this.quantity_on_hand = item.quantity_on_hand;
            return this;
        }

        public ItemResource build(){
            return new ItemResource(this);
        }
    }


    public Long getItemId() {
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
