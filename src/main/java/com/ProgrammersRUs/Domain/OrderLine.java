package com.ProgrammersRUs.Domain;

/**
 * Created by Michael on 14/10/2015.
 */
public class OrderLine {

    private Long id;
    private Long orderId;
    private Long itemId;
    private int quantity;


    public OrderLine(Builder builder){
        this.orderId = builder.orderId;
        this.itemId = builder.itemId;
        this.quantity = builder.quantity;
    }

    public class Builder{

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

        public OrderLine build(Builder builder){
            return new OrderLine(builder);
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
