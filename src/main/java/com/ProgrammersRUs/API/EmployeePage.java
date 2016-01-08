package com.ProgrammersRUs.API;

import com.ProgrammersRUs.Domain.Employee;
import com.ProgrammersRUs.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

/**
 * Created by Braedy Thebus on 31/10/2015.
 */
@RestController
@RequestMapping("/Employee/**")
public class EmployeePage {

    @Autowired
    EmployeeService service;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getEmployees()
    {

        List<Employee> employeeList= service.getEmployees();

        if(employeeList.isEmpty())
        {
            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {

        Employee employee = service.getEmployee(id);

        if(employee == null)
        {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Employee>(employee, HttpStatus.OK);

    }

    @RequestMapping(value="create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder)
    {
        service.createEmployee(employee);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/all").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {

        if (employee ==null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        service.editEmployee(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id) {

        Employee employee1 = service.getEmployee(id);

        if (employee1 == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        service.deleteEmployee(employee1);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }


}
