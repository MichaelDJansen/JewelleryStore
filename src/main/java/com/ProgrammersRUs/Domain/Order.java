package com.ProgrammersRUs.Domain;

import java.util.Date;

/**
 * Created by Michael on 14/10/2015.
 */
public class Order {

    private Long id;
    private Long customerId;
    private Date orderDate;


    public Order(Builder builder){}

    public class Builder{

        private Long id;
        private Long customerId;
        private Date orderDate;

        public Builder(){}

        public Builder(Long customerId,Date orderDate){
            this.customerId = customerId;
            this.orderDate = orderDate;
        }

        public Builder customerId(Long customerId){
            this.customerId = customerId;
            return this;
        }

        public Builder orderDate(Date orderDate){
            this.orderDate = orderDate;
            return this;
        }


        public Builder copy(Order order){
            this.id = order.id;
            this.customerId = order.customerId;
            this.orderDate = order.orderDate;
            return this;
        }

        public Order build(Builder builder){
            return new Order(builder);
        }
    }


    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}
