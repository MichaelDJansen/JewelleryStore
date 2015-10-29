package com.ProgrammersRUs.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by yusraAdmin on 10/29/2015.
 */
public class SupplierResource extends ResourceSupport {

    private Long id;
    private String supplierName;
    private Long itemId;
    private String type;

    protected SupplierResource(){}

    public SupplierResource(Builder builder){
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

        public Builder copy(SupplierResource supplier){
            this.id = supplier.id;
            this.supplierName = supplier.supplierName;
            this.itemId = supplier.itemId;
            this.type = supplier.type;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public SupplierResource build(){
            return new SupplierResource(this);
        }
    }



    public Long getSupplierId() {
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
