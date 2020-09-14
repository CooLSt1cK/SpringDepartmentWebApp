package com.aleksieienko.department.web.app.controller;

import com.aleksieienko.department.web.app.Paths;
import com.aleksieienko.department.web.app.entity.Department;
import com.aleksieienko.department.web.app.service.DepartmentService;
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
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("")
    public String departmentHome(Model model){
        model.addAttribute("departments", departmentService.findAll());
        return Paths.DEPARTMENT;
    }

    @GetMapping("/add")
    public String addDepartment(Model model){
        model.addAttribute("department", new Department());

        return Paths.ADD_DEPARTMENT;
    }

    @PostMapping("/add")
    public String addDepartment(@ModelAttribute Department department, Model model) throws Exception {
        departmentService.save(department);

        return Paths.DEPARTMENT_REDIRECT;
    }

    @GetMapping("{id}/edit")
    public String editDepartment(@PathVariable Integer id, Model model){
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);

        return Paths.EDIT_DEPARTMENT;
    }

    @PostMapping("/edit")
    public String editDepartment(@ModelAttribute Department department, Model model) throws Exception {
        departmentService.save(department);

        return Paths.DEPARTMENT_REDIRECT;
    }

    @GetMapping("{id}/remove")
    public String removeDepartment(@PathVariable Integer id, Model model){
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);

        return Paths.REMOVE_EPARTMENT;
    }

    @PostMapping("remove")
    public String removeDepartmentConfirmed(@RequestParam Integer id, Model model){
        Department department = departmentService.findById(id);

        departmentService.deleteById(department);

        return Paths.DEPARTMENT_REDIRECT;
    }

}
