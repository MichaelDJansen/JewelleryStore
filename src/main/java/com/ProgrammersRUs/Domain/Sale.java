package com.ProgrammersRUs.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Michael on 14/10/2015.
 */
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transction_number;
    private Long orderId;

    protected Sale(){}

    public Sale(Builder builder){
        this.transction_number = builder.transction_number;
        this.orderId = builder.orderId;
    }

    public static class Builder{

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

        public Sale build(){
            return new Sale(this);
        }
    }



    public Long getTransction_number() {
        return transction_number;
    }

    public Long getOrderId() {
        return orderId;
    }
}
