package com.ProgrammersRUs.Model;

import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.Name;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by yusraAdmin on 10/29/2015.
 */
public class EmployeeResource extends ResourceSupport {

    private Long id;
    private Name name;
    private Address address;
    private float salary;

    protected EmployeeResource(){}

    public EmployeeResource(Builder builder){
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

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copy(EmployeeResource employee){
            this.id = employee.id;
            this.name = employee.name;
            this.address = employee.address;
            this.salary = employee.salary;
            return this;
        }

        public EmployeeResource build() {
            return new EmployeeResource(this);
        }
    }


    public Long getEmployeeId() {
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
