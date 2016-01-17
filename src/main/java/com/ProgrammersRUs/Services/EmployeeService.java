package com.ProgrammersRUs.Services;

import com.ProgrammersRUs.Domain.Employee;

import java.util.List;

/**
 * Created by Michael on 17/10/2015.
 */
public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployee(Long id);

    Employee createEmployee(Employee employee);

    Employee editEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    List<Employee> findEmployeeBySurname(String surname);

    Employee findEmployeeByUsername(String username);

}
