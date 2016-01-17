package com.ProgrammersRUs.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Michael on 14/10/2015.
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Name name;
    private String companyName;
    private ContactInformation contactInformation;
    private Address address;
    private String username;
    private String password;


    protected Customer(){}

    public Customer(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.companyName = builder.companyName;
        this.contactInformation = builder.contactInformation;
        this.address = builder.address;
        this.username = builder.username;
        this.password = builder.password;

    }

    public static class Builder{
        private Long id;
        private Name name;
        private String companyName;
        private ContactInformation contactInformation;
        private Address address;
        private String username;
        private String password;

        public Builder(){
        }

        public Builder(Name name,ContactInformation contactInformation){
            this.name = name;
            this.contactInformation = contactInformation;
        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Builder companyName(String companyName)
        {
            this.companyName = companyName;
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

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder copy(Customer customer){
            this.id = customer.id;
            this.name = customer.name;
            this.companyName = customer.companyName;
            this.contactInformation = customer.contactInformation;
            this.address = customer.address;
            this.username = customer.username;
            this.password = customer.password;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public String getCompanyName() {return companyName;}

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public Address getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
