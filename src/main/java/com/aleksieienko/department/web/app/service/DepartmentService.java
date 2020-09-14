package com.aleksieienko.department.web.app.service;

import com.aleksieienko.department.web.app.entity.Department;

public interface DepartmentService {
    Iterable<Department> findAll();

    Department findById(Integer id);

    Department save(Department department) throws Exception;

    void deleteById(Integer id);

    void deleteById(Department department);
}
