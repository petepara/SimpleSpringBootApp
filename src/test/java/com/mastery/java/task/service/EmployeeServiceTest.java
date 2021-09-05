package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


import static org.mockito.Mockito.*;
@SpringBootTest
public class EmployeeServiceTest {
    @MockBean
    private EmployeeDao employeeDao;
    @Autowired
    private EmployeeService employeeService;

    @Test
    void testFindById() {
        Employee employee = new Employee(111L,
                "Zhir",
                "Maslov",
                11,
                "Huligan",
                Gender.MALE,
                LocalDate.of(1941, 12, 31));
        doReturn(employee).when(employeeDao).findById(111L);

        Employee returnedEmployee = employeeService.findById(111L);
        Assertions.assertSame(returnedEmployee, employee, "The employee returned was not the same as the mock");
    }

    @Test
    void testFindAll() {
        Employee employee1 = new Employee(85l,
                "Kira",
                "Arik",
                15,
                "DJ",
                Gender.FEMALE,
                LocalDate.of(1941, 5, 30));
        Employee employee2 = new Employee(90l,
                "Soso",
                "Assa",
                14,
                "manager",
                Gender.FEMALE,
                LocalDate.of(1940, 6, 30));
        doReturn(Arrays.asList(employee1, employee2)).when(employeeDao).findAll();

        // Execute the service call
        List<Employee> employees = employeeService.findAll();

        // Assert the response
        Assertions.assertEquals(2, employees.size(), "findAll should return 2 employee");
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee(22L,
                "Soso",
                "Assa",
                14,
                "manager",
                Gender.FEMALE,
                LocalDate.of(1961, 9, 1));
        employeeService.addEmployee(employee);

        verify(employeeDao, times(1)).addEmployee(employee);
    }


}
