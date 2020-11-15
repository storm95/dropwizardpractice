package com.ankit.practice.dao;

import com.ankit.practice.entity.Employee;
import com.ankit.practice.mapper.EmployeeMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(EmployeeMapper.class)
public interface EmployeeDao {

    @SqlQuery("select * from employee;")
    List<Employee> getEmployees();

    @SqlUpdate("insert into employee (name) values(:name)")
    void createEmployee(@Bind("name") String name);
}
