package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.Domain.Employee;

import java.util.List;

/**
 * Created by Braedy Thebus on 17/10/2015.
 */
public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployee(Long id);

    List<Employee> findEmployeeBySurname(String surname);

}
