package com.ProgrammersRUs.Domain;

/**
 * Created by Michael on 14/10/2015.
 */
public class Supplier {
    private Long id;
    private String supplierName;
    private Long itemId;
    private String type;

    private Supplier(){}


    public Supplier(Builder builder){}

    public class Builder{

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

        public Supplier build(Builder builder){
            return new Supplier(builder);
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
