package com.ProgrammersRUs.Domain;

/**
 * Created by Michael on 14/10/2015.
 */
public class Employee {

    private Long id;
    private Name name;
    private Address address;
    private float salary;

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

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public float getSalary() {
        return salary;
    }
}
