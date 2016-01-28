package com.fexco.testhello.api;

import com.fexco.testhello.model.Employee;
import com.fexco.testhello.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cgriffin on 27/01/16.
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employee;


    @RequestMapping(path = "/api/employees/ids/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") int id) {
        Employee tempEmployee = employee.findById(id);

        if (tempEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tempEmployee, HttpStatus.OK);

    }

    @RequestMapping(path = "/api/employees/salaries/{salary}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("salary") double salary) {
        Employee tempEmployee = employee.findBySalary(salary);

        if (tempEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tempEmployee, HttpStatus.OK);

    }

    @RequestMapping(value = "/api/employees/names/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable("name") String name) {
        Employee tempEmp = employee.findByName(name);

        if (tempEmp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tempEmp, HttpStatus.OK);
    }


    @RequestMapping(path = "/api/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> allEmployees = employee.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @RequestMapping(path = "/api/employees", method = RequestMethod.POST)
    ResponseEntity<Employee> createEmployee(@RequestBody Employee empl) {
        employee.createEmployee(empl.getName(), empl.getSalary());
        return new ResponseEntity<>(empl, HttpStatus.CREATED);
    }


    @RequestMapping(path = "/api/employees/{id}", method = RequestMethod.PUT)
    ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee empl) {
        Employee tempEmp = employee.findById(id);

        if (tempEmp == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        tempEmp.setName(empl.getName());
        tempEmp.setSalary(empl.getSalary());

        return new ResponseEntity<Employee>(tempEmp, HttpStatus.OK);
    }


    @RequestMapping(path = "/api/employees/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
        Employee tempEmp = employee.findById(id);

        if (tempEmp == null) {

            return new ResponseEntity<>("Error. No match was found to delete.", HttpStatus.NOT_FOUND);
        }

        employee.deleteEmployee(tempEmp);

        return new ResponseEntity<Employee>(tempEmp, HttpStatus.OK);
    }


}
