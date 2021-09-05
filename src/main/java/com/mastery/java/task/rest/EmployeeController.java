package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public String getEmployee(@PathVariable long id, ModelMap employeeModel) {
        Employee employee = employeeService.findById(id);
        employeeModel.addAttribute("employee", employee);
        return "employee";
    }

    @GetMapping("/employees")
    public String getEmployees(ModelMap employeeModel) {
        List<Employee> employees = employeeService.findAll();
        employeeModel.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("addEmployee")
    public String addPage() {
        return "add";
    }

    @PostMapping("/add/employee")
    public String addTeacher(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam(required = false) Integer departmentId,
                             @RequestParam(required = false) String jobTitle,
                             @RequestParam String gender,
                             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
                             ModelMap employeeModel) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setDepartmentId(departmentId);
        employee.setJobTitle(jobTitle);
        employee.setGender(Gender.valueOf(gender));
        employee.setDateOfBirth(dateOfBirth);
        employeeService.addEmployee(employee);
        employeeModel.addAttribute("msg", "Employee added successfully");
        List<Employee> employees = employeeService.findAll();
        employeeModel.addAttribute("employees", employees);
        return "redirect:/employees";
    }

    @GetMapping("update/employee/{id}")
    public String updatePage(@PathVariable("id") Long id, ModelMap employeeModel) {
        employeeModel.addAttribute("id", id);
        Employee employee = employeeService.findById(id);
        employeeModel.addAttribute("employee", employee);
        return "update";
    }

    @PostMapping("/update/employee")
    public String updateEmployee(@RequestParam Long id,
                                 @RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam Integer departmentId,
                                 @RequestParam String jobTitle,
                                 @RequestParam String gender,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
                                 ModelMap employeeModel) {
        Employee employee = new Employee(id, firstName, lastName, departmentId, jobTitle, Gender.valueOf(gender), dateOfBirth);
        employeeService.updateEmployee(employee);
        List<Employee> employees = employeeService.findAll();
        employeeModel.addAttribute("employees", employees);
        employeeModel.addAttribute("id", id);
        employeeModel.addAttribute("msg", "Employee updated successfully");
        return "redirect:/employees";
    }

    @GetMapping("/delete/employee/{id}")
    public String deleteEmployee(@PathVariable Long id, ModelMap employeeModel) {
        employeeService.deleteEmployee(id);
        List<Employee> employees = employeeService.findAll();
        employeeModel.addAttribute("employees", employees);
        employeeModel.addAttribute("msg", "Employee deleted successfully");
        return "redirect:/employees";
    }

}
