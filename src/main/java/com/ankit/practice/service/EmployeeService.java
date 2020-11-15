package com.ankit.practice.service;

import com.ankit.practice.dao.EmployeeDao;
import com.ankit.practice.entity.Employee;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class EmployeeService {

    @CreateSqlObject
    abstract EmployeeDao employeeDao();

    public List<Employee> getEmployees() {
        return employeeDao().getEmployees();
    }

    public void createEmployee(String name) {
        System.out.println("ldkjflksdfj");
        employeeDao().createEmployee(name);
    }
}
