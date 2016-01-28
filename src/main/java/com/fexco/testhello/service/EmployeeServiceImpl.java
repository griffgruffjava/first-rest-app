package com.fexco.testhello.service;

import com.fexco.testhello.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nalam on 28/01/16.
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employeeList;

//    static {
//        employeeList = populateStaff();
//    }

    public EmployeeServiceImpl() {
        this.employeeList = populateStaff();
    }

    public List<Employee> populateStaff() {
        List<Employee> staff = new ArrayList<>();
        staff.add(new Employee(1, "ciaran", 1000000));
        staff.add(new Employee(2, "naz", 100));

        return staff;

    }

    @Override
    public Employee findById(int id) {
        for (Employee empl : employeeList) {
            if (empl.getId() == id)
                return empl;
        }
        return null;
    }

    @Override
    public Employee findByName(String name) {
        for (Employee empl : employeeList) {
            if ( empl.getName().equalsIgnoreCase(name) ) {
                return empl;
            }
        }
        return null;
    }

    @Override
    public Employee findBySalary(double salary) {
        for (Employee empl : employeeList) {
            if (empl.getSalary() == salary)
                return empl;
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public void createEmployee(Employee empl) {
        employeeList.add(empl);
    }

    @Override
    public void updateEmployee(Employee searchEmpl) {
        for (Employee empl : employeeList) {
            if (empl.getId() == searchEmpl.getId()) {
                empl.setName(searchEmpl.getName());
                empl.setSalary(searchEmpl.getSalary());
            }
        }
    }

    @Override
    public void deleteEmployee(Employee searchEmpl) {
        for (Employee empl : employeeList) {
            if (empl.getId() == searchEmpl.getId()) {
                employeeList.remove(searchEmpl);
            }
        }
    }

}
