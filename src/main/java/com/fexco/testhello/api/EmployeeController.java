package com.fexco.testhello.api;

import com.fexco.testhello.model.Employee;
import com.fexco.testhello.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cgriffin on 27/01/16.
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employee;


    @RequestMapping(path = "/api/ids/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") int id) {
        Employee tempEmployee = employee.findById(id);

        if (tempEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tempEmployee, HttpStatus.OK);

    }

    @RequestMapping(path = "/api/salaries/{salary}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("salary") double salary) {
        Employee tempEmployee = employee.findBySalary(salary);

        if (tempEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tempEmployee, HttpStatus.OK);

    }

    @RequestMapping(value = "/api/names/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable("name") String name) {
        Employee tempEmp = employee.findByName(name);

        if (tempEmp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tempEmp, HttpStatus.OK);
    }

}
