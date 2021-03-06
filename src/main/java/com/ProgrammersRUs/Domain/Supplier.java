package com.ProgrammersRUs.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Michael on 14/10/2015.
 */
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String supplierName;
    private Long itemId;
    private String type;

    protected Supplier(){}

    public Supplier(Builder builder){
        this.id = builder.id;
        this.supplierName = builder.supplierName;
        this.itemId = builder.itemId;
        this.type = builder.type;
    }

    public static class Builder{

        private Long id;
        private String supplierName;
        private Long itemId;
        private String type;

        public Builder(){}

        public Builder(String supplierName,Long itemId,String type){
            this.supplierName = supplierName;
            this.itemId = itemId;
            this.type = type;
        }

        public Builder supplierName(String supplierName){
            this.supplierName = supplierName;
            return this;
        }

        public Builder itemId(Long itemId){
            this.itemId = itemId;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder copy(Supplier supplier){
            this.id = supplier.id;
            this.supplierName = supplier.supplierName;
            this.itemId = supplier.itemId;
            this.type = supplier.type;
            return this;
        }

        public Supplier build(){
            return new Supplier(this);
        }
    }



    public Long getId() {
        return id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getType() {
        return type;
    }
}
