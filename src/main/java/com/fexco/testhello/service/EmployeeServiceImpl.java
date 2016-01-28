package com.fexco.testhello.service;

import com.fexco.testhello.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nalam on 28/01/16.
 */
@Component("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employeeList;
    private AtomicInteger counter = new AtomicInteger();

//    static {
//        employeeList = populateStaff();
//    }

    public EmployeeServiceImpl() {
        this.employeeList = populateStaff();
    }

    private List<Employee> populateStaff() {
        List<Employee> staff = new CopyOnWriteArrayList<>();
        staff.add(new Employee(counter.getAndIncrement(), "Ciaran Griffin", 1000000));
        staff.add(new Employee(counter.getAndIncrement(), "Nazmul Alam", 9000000));
        staff.add(new Employee(counter.getAndIncrement(), "Terry McSweeney", 500));
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
            if (empl.getName().equalsIgnoreCase(name)) {
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
    public void createEmployee(String name, double salary) {
        employeeList.add(new Employee(counter.getAndIncrement(), name, salary));
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
