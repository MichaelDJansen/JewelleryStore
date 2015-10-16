package com.ProgrammersRUs.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Michael on 14/10/2015.
 */

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Name name;
    private Address address;
    private float salary;


    public Employee(Builder builder){
        this.name = builder.name;
        this.address = builder.address;
        this.salary = builder.salary;
    }

    public static class Builder{

        private Long id;
        private Name name;
        private Address address;
        private float salary;

        public Builder(){}

        public Builder(Name name,Address address,float salary){
            this.name = name;
            this.address = address;
            this.salary = salary;
        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Builder address(Address address){
            this.address = address;
            return this;
        }

        public Builder salary(float salary){
            this.salary = salary;
            return this;
        }

        public Builder copy(Employee employee){
            this.id = employee.id;
            this.name = employee.name;
            this.address = employee.address;
            this.salary = employee.salary;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }


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
