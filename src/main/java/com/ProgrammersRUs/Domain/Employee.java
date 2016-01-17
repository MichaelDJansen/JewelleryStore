package com.ProgrammersRUs.Domain;

import com.ProgrammersRUs.Hash;

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
    private String username;
    private String password;

    protected Employee(){}

    public Employee(Builder builder){
        this.name = builder.name;
        this.username = builder.username;
        this.password = builder.password;
    }

    public static class Builder{

        private Long id;
        private Name name;
        private String username;
        private String password;

        public Builder(){}

        public Builder(Name name,String username, String password){
            this.name = name;
            this.username = username;
            this.password = Hash.md5(password);
        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Builder username(String username)
        {
            this.username = username;
            return this;
        }

        public Builder password(String password)
        {
            this.password = Hash.md5(password);
            return this;
        }

        public Builder copy(Employee employee){
            this.id = employee.id;
            this.name = employee.name;
            this.username = employee.username;
            this.password = employee.password;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
