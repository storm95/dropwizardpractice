package com.ankit.practice.mapper;

import com.ankit.practice.entity.Employee;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements ResultSetMapper<Employee> {
    private static final String ID = "id";
    private static final String NAME = "name";

    public Employee map(int i, ResultSet resultSet, StatementContext statementContext)
            throws SQLException {
        Employee employee = new Employee(resultSet.getString(NAME));
        employee.setId(resultSet.getInt(ID));
        return employee;
    }
}
