package com.ProgrammersRUs.Domain;

import javax.persistence.Entity;

/**
 * Created by Michael on 14/10/2015.
 */
public class Sale {

    private Long transction_number;
    private Long orderId;

     /*
    public Supplier(Builder builder){}

    public class Builder{

        public Builder(){}

        public Builder copy(){}

        public Supplier build(){}
    }
    */


    public Long getTransction_number() {
        return transction_number;
    }

    public Long getOrderId() {
        return orderId;
    }
}
