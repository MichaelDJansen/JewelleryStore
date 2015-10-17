package com.ProgrammersRUs.Domain;

import javax.persistence.Embeddable;

/**
 * Created by Michael on 14/10/2015.
 */
@Embeddable
public class Name {
    private String firstName;
    private String middleName;
    private String surname;


    public Name(Builder builder){
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.surname = builder.surname;
    }

    protected Name(){}

    public static class Builder{

        private String firstName;
        private String middleName;
        private String surname;

        public Builder(){}

        public Builder(String firstName,String surname){
            this.firstName = firstName;
            this.surname = surname;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName){
            this.middleName = middleName;
            return this;
        }

        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }


        public Builder copy(Name name){
            this.firstName = name.firstName;
            this.middleName = name.middleName;
            this.surname = name.surname;
            return this;
        }

        public Name build(){
            return new Name(this);
        }
    }


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
