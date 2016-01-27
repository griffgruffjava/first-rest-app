package com.fexco.testhello.model;

import java.util.Set;

/**
 * Created by cgriffin on 27/01/16.
 */
public class EmployeeRepo
{
    private Set<Employee> staff;

    public EmployeeRepo(Set<Employee> staff)
    {
        this.staff = staff;
    }

    public EmployeeRepo(Employee staff)
    {

    }

    public Set<Employee> getStaff()
    {
        return staff;
    }

    public void setStaff(Set<Employee> staff)
    {
        this.staff = staff;
    }


}
