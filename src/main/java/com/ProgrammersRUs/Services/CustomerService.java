package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.Domain.Customer;

import java.util.List;

/**
 * Created by Michael on 17/10/2015.
 */
public interface CustomerService {

    public List<Customer> getCustomers();

    public Customer getCustomer(Long id);

    public Customer createCustomer(Customer customer);

    public Customer editCustomer(Customer customer);

    public void deleteCustomer(Customer customer);

    public List<Customer> customersInSameProvince(String province);

    public Customer findByCellphoneNumber(String cellphone);

    public List<Customer> findBySurname(String surname);

}
