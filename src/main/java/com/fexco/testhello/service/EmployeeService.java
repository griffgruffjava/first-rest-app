package com.fexco.testhello.service;

import com.fexco.testhello.model.Employee;

import java.util.List;

/**
 * Created by nalam on 28/01/16.
 */
public interface EmployeeService {

    Employee findById(int id);

    Employee findByName(String name);

    Employee findBySalary(double salary);

    List<Employee> getAllEmployees();

    Employee createEmployee(String name, double salary);

    void updateEmployee(Employee empl);

    void deleteEmployee(Employee empl);

}
