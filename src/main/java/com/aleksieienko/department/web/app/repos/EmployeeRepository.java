package com.aleksieienko.department.web.app.repos;

import com.aleksieienko.department.web.app.entity.Employee;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findByDepartmentId(Integer id);
}
