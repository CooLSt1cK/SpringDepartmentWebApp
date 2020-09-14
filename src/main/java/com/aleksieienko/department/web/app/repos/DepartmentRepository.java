package com.aleksieienko.department.web.app.repos;

import com.aleksieienko.department.web.app.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}
