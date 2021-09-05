package com.mastery.java.task.mapper;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Employee(resultSet.getLong("employee_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getInt("department_id"),
                            resultSet.getString("job_title"),
                            Gender.valueOf(resultSet.getString("gender")),
                            resultSet.getDate("date_of_birth").toLocalDate());
    }
}
