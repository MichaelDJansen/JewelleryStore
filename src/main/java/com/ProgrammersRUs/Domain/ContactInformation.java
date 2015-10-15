package com.ProgrammersRUs.Domain;

import javax.persistence.Embeddable;

/**
 * Created by Michael on 14/10/2015.
 */
@Embeddable
public class ContactInformation {
    private String email;
    private String telephone;
    private String cellphone;


    public ContactInformation(Builder builder){
        email = builder.email;
        cellphone = builder.cellphone;
        telephone = builder.telephone;
    }

    public class Builder{

        private String email;
        private String telephone;
        private String cellphone;

        public Builder(){}

        public Builder(String cellphone,String email){
            this.email = email;
            this.cellphone = cellphone;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder cellphone(String cellphone){
            this.cellphone = cellphone;
            return this;
        }

        public Builder telephone(String telephone){
            this.telephone = telephone;
            return this;
        }

        public Builder copy(ContactInformation contactInformation){
            this.email = contactInformation.email;
            this.cellphone = contactInformation.cellphone;
            this.telephone = contactInformation.telephone;
            return this;
        }

        public ContactInformation build(Builder builder){

            return new ContactInformation(builder);
        }
    }


    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCellphone() {
        return cellphone;
    }
}
