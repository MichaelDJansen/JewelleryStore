package com.ProgrammersRUs.Factories;

import com.ProgrammersRUs.Domain.Address;
import com.ProgrammersRUs.Domain.Employee;
import com.ProgrammersRUs.Domain.Name;

/**
 * Created by Michael on 16/10/2015.
 */
public class EmployeeFactory {
    public static Employee createEmployee(Name name,String username, String password){
        Employee employee = new Employee.Builder(name,username,password).build();

        return employee;
    }
}
