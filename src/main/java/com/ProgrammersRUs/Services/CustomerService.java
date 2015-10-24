package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.Domain.Customer;

import java.util.List;

/**
 * Created by Braedy Thebus on 17/10/2015.
 */
public interface CustomerService {

    public List<Customer> getCustomers();

    public Customer getCustomer(Long id);

    public List<Customer> customersInSameProvince(String province);

    public Customer findByCellphoneNumber(String cellphone);

    public List<Customer> findBySurname(String surname);

}
