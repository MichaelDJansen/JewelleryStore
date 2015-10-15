package com.ProgrammersRUs.Domain;

/**
 * Created by Michael on 14/10/2015.
 */
public class Supplier {
    private Long id;
    private String supplierName;
    private int itemId;
    private String type;

    private Supplier(){}

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

    public String getSupplierName() {
        return supplierName;
    }

    public int getItemId() {
        return itemId;
    }

    public String getType() {
        return type;
    }
}
