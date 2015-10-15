package com.ProgrammersRUs.Domain;

/**
 * Created by Michael on 14/10/2015.
 */
public class Name {
    private String firstName;
    private String middleName;
    private String surname;

     /*
    public Supplier(Builder builder){}

    public class Builder{

        public Builder(){}

        public Builder copy(){}

        public Supplier build(){}
    }
    */

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }
}
