package com.ProgrammersRUs.Domain;

import javax.persistence.Entity;

/**
 * Created by Michael on 14/10/2015.
 */
public class Sale {

    private Long transction_number;
    private Long orderId;


    public Sale(Builder builder){
        this.transction_number = builder.transction_number;
        this.orderId = builder.orderId;
    }

    public class Builder{

        private Long transction_number;
        private Long orderId;

        public Builder(){}

        public Builder(Long orderId){
            this.orderId = orderId;
        }
        public Builder orderId(Long orderId){
            this.orderId = orderId;
            return this;
        }

        public Builder copy(Sale sale){
            this.transction_number = sale.transction_number;
            this.orderId = sale.orderId;
            return this;
        }

        public Sale build(Builder builder){
            return new Sale(builder);
        }
    }



    public Long getTransction_number() {
        return transction_number;
    }

    public Long getOrderId() {
        return orderId;
    }
}
