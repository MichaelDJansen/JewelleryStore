package com.ProgrammersRUs.Services.Impl;

import com.ProgrammersRUs.Domain.Customer;
import com.ProgrammersRUs.Repositories.CustomerRepository;
import com.ProgrammersRUs.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusraAdmin on 10/27/2015.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public List<Customer> getCustomers(){
        List<Customer> allCustomers = new ArrayList<Customer>();

        Iterable<Customer> customers = repository.findAll();
        for(Customer customer: customers)
        {
            allCustomers.add(customer);
        }


        return allCustomers;
    }

    @Override
    public Customer getCustomer(Long id){

        Customer customer = repository.findOne(id);

        return customer;
    }

    @Override
    public Customer createCustomer(Customer customer)
    {
        return repository.save(customer);
    }

    @Override
    public Customer editCustomer(Customer customer)
    {
        return repository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer)
    {
        repository.delete(customer);
    }

    public List<Customer> customersInSameProvince(String province){

        List<Customer> matchedCustomers = new ArrayList<Customer>();

        Iterable<Customer> allCustomers = repository.findAll();
        for(Customer customer: allCustomers)
        {
            if(customer.getAddress().getProvince().equalsIgnoreCase(province))
            {
                matchedCustomers.add(customer);
            }
        }

        return matchedCustomers;
    }

    public Customer findByCellphoneNumber(String cellphone){
        Customer foundCustomer = null;

        Iterable<Customer> allCustomers = repository.findAll();
        for(Customer customer: allCustomers)
        {
            if(customer.getContactInformation().getCellphone().equalsIgnoreCase(cellphone))
            {
                foundCustomer = customer;
                break;
            }
        }

        return foundCustomer;
    }

    public List<Customer> findBySurname(String surname){

        List<Customer> matchedCustomers = new ArrayList<Customer>();

        Iterable<Customer> allCustomers = repository.findAll();
        for(Customer customer: allCustomers)
        {
            if(customer.getName().getSurname().equalsIgnoreCase(surname))
            {
                matchedCustomers.add(customer);
            }
        }

        return matchedCustomers;
    }
}
