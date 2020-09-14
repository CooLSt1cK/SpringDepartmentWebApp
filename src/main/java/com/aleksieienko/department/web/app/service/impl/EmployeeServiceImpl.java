package com.aleksieienko.department.web.app.service.impl;

import com.aleksieienko.department.web.app.entity.Employee;
import com.aleksieienko.department.web.app.repos.EmployeeRepository;
import com.aleksieienko.department.web.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Iterable<Employee> findByDepartmentId(Integer id) {
        return employeeRepository.findByDepartmentId(id);
    }

    @Override
    public Employee save(Employee employee) throws Exception {
        if(!employee.isValid()){
            throw new Exception("Employee's data is not valid");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteById(Employee employee) {
        employeeRepository.delete(employee);
    }
}
