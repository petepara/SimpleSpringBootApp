package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeDao employeeDao;
    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee findById(Long id){
        return employeeDao.findById(id);
    }
    public List<Employee> findAll(){
        return employeeDao.findAll();
    }
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }
    public void deleteEmployee(Long id) {
        employeeDao.deleteEmployee(id);
    }
}
