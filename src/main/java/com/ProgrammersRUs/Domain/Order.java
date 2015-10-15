package com.ProgrammersRUs.Domain;

import java.util.Date;

/**
 * Created by Michael on 14/10/2015.
 */
public class Order {

    private Long id;
    private Long customerId;
    private Date orderDate;

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

    public Long getCustomerId() {
        return customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}
