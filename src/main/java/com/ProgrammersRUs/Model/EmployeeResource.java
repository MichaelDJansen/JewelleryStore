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
    private String username;
    private String password;

    protected EmployeeResource(){}

    public EmployeeResource(Builder builder){
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

        public Builder(Name name,String username,String password){
            this.name = name;
            this.username = username;
            this.password = password;
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
            this.password = password;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copy(EmployeeResource employee){
            this.id = employee.id;
            this.name = employee.name;
            this.username = employee.username;
            this.password = employee.password;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
