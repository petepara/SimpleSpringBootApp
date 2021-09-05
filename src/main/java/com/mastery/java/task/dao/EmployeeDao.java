package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public class EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employee WHERE employee_id = ?", new Object[]{id},
                new EmployeeMapper());
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employee ORDER BY employee_id", new EmployeeMapper());
    }

    public void addEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth)" +
                                "VALUES (?,?,?,?,cast (? as gender),?)",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getDepartmentId(),
                            employee.getJobTitle(),
                            employee.getGender().name(),
                Date.valueOf(employee.getDateOfBirth()));
    }

    public void updateEmployee(Employee employee) {
        jdbcTemplate.update("UPDATE employee SET first_name = ?, last_name = ?, department_id = ?, job_title = ?, gender = cast (? as gender), date_of_birth = ?" +
                        " WHERE employee_id = ?;",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTitle(),
                employee.getGender().name(),
                employee.getDateOfBirth(),
                employee.getEmployeeId());
    }

    public void deleteEmployee(Long id) {
        jdbcTemplate.update("DELETE FROM employee where employee_id = ?", id);
    }
}
