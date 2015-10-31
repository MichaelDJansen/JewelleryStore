package com.ProgrammersRUs.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Braedy Thebus on 31/10/2015.
 */
public class SaleResource extends ResourceSupport{

    private Long transaction_number;
    private Long orderId;

    protected SaleResource(){}

    public SaleResource(Builder builder){
        this.transaction_number = builder.transaction_number;
        this.orderId = builder.orderId;
    }

    public static class Builder{

        private Long transaction_number;
        private Long orderId;

        public Builder(){}

        public Builder(Long orderId){
            this.orderId = orderId;
        }
        public Builder orderId(Long orderId){
            this.orderId = orderId;
            return this;
        }

        public Builder copy(SaleResource sale){
            this.transaction_number = sale.transaction_number;
            this.orderId = sale.orderId;
            return this;
        }

        public Builder transaction_number(Long transaction_number){
            this.transaction_number = transaction_number;
            return this;
        }

        public SaleResource build(){
            return new SaleResource(this);
        }
    }

    public Long getTransaction_number() {
        return transaction_number;
    }

    public Long getOrderId() {
        return orderId;
    }
    
}
