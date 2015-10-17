package com.ProgrammersRUs.Domain;

import javax.persistence.Embeddable;

/**
 * Created by Michael on 14/10/2015.
 */

@Embeddable
public class Address {

    private String streetNumber;
    private String streetName;
    private String town;
    private String province;
    private String postalCode;

    protected Address(){}

    public Address(Builder builder){
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.town = builder.town;
        this.province = builder.province;
        this.postalCode = builder.postalCode;}

    public static class Builder{

        private String streetNumber;
        private String streetName;
        private String town;
        private String province;
        private String postalCode;

        public Builder(){}

        public Builder(String streetNumber,String streetName,String town,String province,String postalCode){
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.town = town;
        this.province = province;
        this.postalCode = postalCode;
        }

        public Builder streetName(String streetName){
            this.streetName = streetName;
            return this;
        }

        public Builder streetNumber(String streetNumber){
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder town(String town){
            this.town = town;
            return this;
        }

        public Builder province(String province){
            this.province = province;
            return this;
        }

        public Builder postalCode(String postalCode){
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy(Address address){
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.town = address.town;
            this.province = address.province;
            this.postalCode = address.postalCode;
            return this;
        }

        public Address build(){
        return new Address(this);
        }
    }


    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getTown() {
        return town;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
