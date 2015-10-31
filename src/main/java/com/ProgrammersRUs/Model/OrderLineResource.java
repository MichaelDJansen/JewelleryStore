package com.ProgrammersRUs.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Braedy Thebus on 31/10/2015.
 */

public class OrderLineResource extends ResourceSupport {

    private Long id;
    private Long orderId;
    private Long itemId;
    private int quantity;

    protected OrderLineResource(){}

    public OrderLineResource(Builder builder){
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

        public Builder copy(OrderLineResource orderLine){
            this.id = orderLine.id;
            this.orderId = orderLine.orderId;
            this.itemId = orderLine.itemId;
            this.quantity = orderLine.quantity;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public OrderLineResource build() {
            return new OrderLineResource(this);
        }
    }

    public Long getOrderLineId() {
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
