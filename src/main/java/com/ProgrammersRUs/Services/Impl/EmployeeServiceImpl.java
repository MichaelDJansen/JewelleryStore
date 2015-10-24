package com.ProgrammersRUs.Services.Impl;

import com.ProgrammersRUs.Domain.Employee;
import com.ProgrammersRUs.Domain.Employee;
import com.ProgrammersRUs.Repositories.EmployeeRepository;
import com.ProgrammersRUs.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Braedy Thebus on 17/10/2015.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public List<Employee> getEmployees(){

        List<Employee> allEmployees = new ArrayList<Employee>();

        Iterable<Employee> employees = repository.findAll();
        for(Employee employee: employees)
        {
            allEmployees.add(employee);
        }


        return allEmployees;
        
    }

    public Employee getEmployee(Long id){
        Employee employee = repository.findOne(id);

        return employee;
    }

    public List<Employee> findEmployeeBySurname(String surname){

        List<Employee> matchedEmployees = new ArrayList<Employee>();

        Iterable<Employee> allEmployees = repository.findAll();
        for(Employee employee: allEmployees)
        {
            if(employee.getName().getSurname().equalsIgnoreCase(surname))
            {
                matchedEmployees.add(employee);
            }
        }

        return matchedEmployees;
        
    }


}
