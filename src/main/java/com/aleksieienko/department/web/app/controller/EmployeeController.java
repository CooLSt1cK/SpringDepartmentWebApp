package com.aleksieienko.department.web.app.controller;

import com.aleksieienko.department.web.app.Paths;
import com.aleksieienko.department.web.app.entity.Employee;
import com.aleksieienko.department.web.app.service.DepartmentService;
import com.aleksieienko.department.web.app.service.EmployeeService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/by/department/id/{id}")
    public String employees(@PathVariable Integer id, Model model) {
        model.addAttribute("employees", employeeService.findByDepartmentId(id));
        model.addAttribute("departmentId", id);

        return Paths.EMPLOYEE;
    }

    @GetMapping("/{id}/add")
    public String addEmployee(@PathVariable Integer id, Model model){
        Employee employee = new Employee();
        employee.setDepartmentId(id);
        model.addAttribute("employee", employee);

        return Paths.ADD_EMPLOYEE;
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee, Model model) throws Exception {
        employeeService.save(employee);

        return Paths.EMPLOYEE_REDIRECT + employee.getDepartmentId();
    }

    @GetMapping("/{id}/edit")
    public String editEmployee(@PathVariable Integer id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("departments", departmentService.findAll());

        return Paths.EDIT_EMPLOYEE;
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee employee, @RequestParam Integer oldDepartment, Model model) throws Exception {
        employeeService.save(employee);

        return Paths.EMPLOYEE_REDIRECT + employee.getDepartmentId();
    }

    @GetMapping("/{id}/remove")
    public String removeEmployee(@PathVariable Integer id, Model model){
        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);

        return Paths.REMOVE_EMPLOYEE;
    }

    @PostMapping("/remove")
    public String removeEmployeeConfirm(@RequestParam Integer id, Model model){
        Employee employee = employeeService.findById(id);

        employeeService.deleteById(employee);

        return Paths.EMPLOYEE_REDIRECT + employee.getDepartmentId();
    }
}
