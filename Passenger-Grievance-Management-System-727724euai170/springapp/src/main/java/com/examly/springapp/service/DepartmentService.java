package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Department;

public interface DepartmentService {
    Department addDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department updateDepartment(Long id, Department department);
}
