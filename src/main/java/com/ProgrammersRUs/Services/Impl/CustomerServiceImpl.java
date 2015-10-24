package com.ProgrammersRUs.Services.Impl;

import com.ProgrammersRUs.Domain.Customer;
import com.ProgrammersRUs.Repositories.CustomerRepository;
import com.ProgrammersRUs.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Braedy Thebus on 17/10/2015.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    public List<Customer> getCustomers(){
        List<Customer> allCustomers = new ArrayList<Customer>();

        Iterable<Customer> customers = repository.findAll();
        for(Customer customer: customers)
        {
            allCustomers.add(customer);
        }


        return allCustomers;
    }

    public Customer getCustomer(Long id){

        Customer customer = repository.findOne(id);

        return customer;
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
