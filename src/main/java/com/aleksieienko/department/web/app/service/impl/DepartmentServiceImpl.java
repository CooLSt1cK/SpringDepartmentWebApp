package com.aleksieienko.department.web.app.service.impl;

import com.aleksieienko.department.web.app.entity.Department;
import com.aleksieienko.department.web.app.repos.DepartmentRepository;
import com.aleksieienko.department.web.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Integer id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department save(Department department) throws Exception {
        if(!department.isValid()){
            throw new Exception("Department's name is not valid");
        }
        return departmentRepository.save(department);
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void deleteById(Department department) {
        departmentRepository.delete(department);
    }
}
