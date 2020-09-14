package com.aleksieienko.department.web.app.service;

import com.aleksieienko.department.web.app.entity.Employee;

public interface EmployeeService {
    Iterable<Employee> findAll();

    Employee findById(Integer id);

    Iterable<Employee> findByDepartmentId(Integer id);

    Employee save(Employee employee) throws Exception;

    void deleteById(Integer id);

    void deleteById(Employee employee);
}
