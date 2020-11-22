package com.ankit.practice.service;

import com.ankit.practice.dao.EmployeeDao;
import com.ankit.practice.entity.Employee;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class EmployeeService {

    @CreateSqlObject
    abstract EmployeeDao getEmployeeDao();

    public List<Employee> getAllEmployees() {
        return getEmployeeDao().getEmployees();
    }

    public void createAnEmployee(String name) {
        getEmployeeDao().createEmployee(name);
    }
}
