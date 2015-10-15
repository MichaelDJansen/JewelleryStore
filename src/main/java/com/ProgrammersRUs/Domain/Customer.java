package com.ProgrammersRUs.Domain;

import javax.persistence.Entity;

/**
 * Created by Michael on 14/10/2015.
 */
@Entity
public class Customer {

    private Long id;
    private Name name;
    private ContactInformation contactInformation;
    private Address address;


    public Customer(Builder builder){}

    public class Builder{
        private Long id;
        private Name name;
        private ContactInformation contactInformation;
        private Address address;

        public Builder(){}

        public Builder(Name name,ContactInformation contactInformation){
            this.name = name;
            this.contactInformation = contactInformation;
        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Builder contactInformation(ContactInformation contactInformation){
            this.contactInformation = contactInformation;
            return this;
        }

        public Builder address(Address address){
            this.address = address;
            return this;
        }

        public Builder copy(Customer customer){
            this.id = customer.id;
            this.name = customer.name;
            this.contactInformation = customer.contactInformation;
            this.address = customer.address;
            return this;
        }

        public Customer build(Builder builder){

            return new Customer(builder);
        }
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public Address getAddress() {
        return address;
    }
}
