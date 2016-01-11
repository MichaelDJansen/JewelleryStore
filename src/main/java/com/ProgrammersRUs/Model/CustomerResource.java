package com.ProgrammersRUs.Model;

import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.ContactInformation;
import com.ProgrammersRUs.Domain.Name;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by yusraAdmin on 10/29/2015.
 */
public class CustomerResource extends ResourceSupport {

    private Long id;
    private Name name;
    private String companyName;
    private ContactInformation contactInformation;
    private Address address;

    protected CustomerResource(){}

    public CustomerResource(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.companyName = builder.companyName;
        this.contactInformation = builder.contactInformation;
        this.address = builder.address;

    }

    public static class Builder{
        private Long id;
        private Name name;
        private String companyName;
        private ContactInformation contactInformation;
        private Address address;

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

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copy(CustomerResource customer){
            this.id = customer.id;
            this.name = customer.name;
            this.contactInformation = customer.contactInformation;
            this.address = customer.address;
            this.companyName = customer.companyName;
            return this;
        }

        public CustomerResource build(){
            return new CustomerResource(this);
        }
    }

    public Long getCustomerId() {
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

    public String getCompanyName() {
        return companyName;
    }
}
