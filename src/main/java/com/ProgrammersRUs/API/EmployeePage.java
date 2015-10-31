package com.ProgrammersRUs.API;

import com.ProgrammersRUs.Domain.Employee;
import com.ProgrammersRUs.Model.EmployeeResource;
import com.ProgrammersRUs.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Braedy Thebus on 31/10/2015.
 */
@RestController
@RequestMapping("/employee/**")
public class EmployeePage {

    @Autowired
    EmployeeService service;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String Index()
    {
        return "View Employees";
    }

    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public List<EmployeeResource> getEmployees()
    {
        List<EmployeeResource> hateoas = new ArrayList<EmployeeResource>();
        List<Employee> employees = service.getEmployees();

        for(Employee employee: employees)
        {
            EmployeeResource res = new EmployeeResource.Builder(employee.getName()
                    ,employee.getAddress()
                    ,employee.getSalary())
                    .id(employee.getId())
                    .build();

            Link employeesLink = new
                    Link("http://localhost:8081/employee/all")
                    .withRel("employee");

            res.add(employeesLink);
            hateoas.add(res);
        }

        return hateoas;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeResource getEmployee(@PathVariable("id") Long id) {
            EmployeeResource hateoas;
            Employee employee = service.getEmployee(id);

        EmployeeResource res = new EmployeeResource.Builder(employee.getName()
                ,employee.getAddress()
                ,employee.getSalary())
                .id(employee.getId())
                .build();

            Link employeesLink = new
                    Link("http://localhost:8081/employee/" + id.toString())
                    .withRel("employee");

            res.add(employeesLink);
            hateoas = res;


            return hateoas;
        }

    //FindEmployeeBySurname
    @RequestMapping(value = "/surname/{surname}", method = RequestMethod.GET)
    public List<EmployeeResource> listAllEmployeesBySurname(@PathVariable("surname") String surname) {
        List<EmployeeResource> hateoas = new ArrayList<EmployeeResource>();
        List<Employee> employees = service.findEmployeeBySurname(surname);

        for (Employee employee : employees) {
            EmployeeResource res = new EmployeeResource.Builder(employee.getName()
                    , employee.getAddress()
                    , employee.getSalary())
                    .id(employee.getId())
                    .build();

            Link employeesLink = new
                    Link("http://localhost:8081/employee/surname" + surname)
                    .withRel("employee");

            res.add(employeesLink);
            hateoas.add(res);
        }

        return hateoas;
    }

}
