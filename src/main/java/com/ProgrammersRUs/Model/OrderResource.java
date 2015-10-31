package com.ProgrammersRUs.Model;

import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * Created by Braedy Thebus on 31/10/2015.
 */
public class OrderResource extends ResourceSupport {

    private Long id;
    private Long customerId;
    private Date orderDate;

    protected OrderResource(){}

    public OrderResource(Builder builder){
        this.id = builder.id;
        this.customerId = builder.customerId;
        this.orderDate = builder.orderDate;
    }

    public static class Builder{

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


        public Builder copy(OrderResource order){
            this.id = order.id;
            this.customerId = order.customerId;
            this.orderDate = order.orderDate;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public OrderResource build(){
            return new OrderResource(this);
        }
    }


    public Long getOrderId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Date getOrderResourceDate() {
        return orderDate;
    }
    
}
