package com.ProgrammersRUs.Domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Michael on 14/10/2015.
 */
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long customerId;
    private String orderDate;

    protected Orders(){}

    public Orders(Builder builder){
        this.id = builder.id;
        this.customerId = builder.customerId;
        this.orderDate = builder.orderDate;
    }

    public static class Builder{

        private Long id;
        private Long customerId;
        private String orderDate;

        public Builder(){}

        public Builder(Long customerId,String orderDate){
            this.customerId = customerId;
            this.orderDate = orderDate;
        }

        public Builder customerId(Long customerId){
            this.customerId = customerId;
            return this;
        }

        public Builder orderDate(String orderDate){
            this.orderDate = orderDate;
            return this;
        }


        public Builder copy(Orders orders){
            this.id = orders.id;
            this.customerId = orders.customerId;
            this.orderDate = orders.orderDate;
            return this;
        }

        public Orders build(){
            return new Orders(this);
        }
    }


    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }
}
