package com.ProgrammersRUs.Domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Michael on 14/10/2015.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long customerId;
    private Date orderDate;

    protected Order(){}

    public Order(Builder builder){
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


        public Builder copy(Order order){
            this.id = order.id;
            this.customerId = order.customerId;
            this.orderDate = order.orderDate;
            return this;
        }

        public Order build(){
            return new Order(this);
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
