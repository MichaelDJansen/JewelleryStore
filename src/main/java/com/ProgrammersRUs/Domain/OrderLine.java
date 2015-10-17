package com.ProgrammersRUs.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Michael on 14/10/2015.
 */
@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private Long itemId;
    private int quantity;

    protected OrderLine(){}

    public OrderLine(Builder builder){
        this.orderId = builder.orderId;
        this.itemId = builder.itemId;
        this.quantity = builder.quantity;
    }

    public static class Builder{

        private Long id;
        private Long orderId;
        private Long itemId;
        private int quantity;
        public Builder(){}

        public Builder(Long orderId,Long itemId,int quantity){
            this.orderId = orderId;
            this.itemId = itemId;
            this.quantity = quantity;
        }

        public Builder orderId(Long orderId){
            this.orderId = orderId;
            return this;
        }

        public Builder itemId(Long itemId){
            this.itemId = itemId;
            return this;
        }

        public Builder quantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public Builder copy(OrderLine orderLine){
            this.id = orderLine.id;
            this.orderId = orderLine.orderId;
            this.itemId = orderLine.itemId;
            this.quantity = orderLine.quantity;
            return this;
        }

        public OrderLine build() {
            return new OrderLine(this);
        }
    }


    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }
}
