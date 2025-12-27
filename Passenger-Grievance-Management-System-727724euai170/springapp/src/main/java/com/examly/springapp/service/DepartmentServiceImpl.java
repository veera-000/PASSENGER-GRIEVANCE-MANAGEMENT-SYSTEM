package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    public Department addDepartment(Department department) {
        return repo.save(department);
    }

    public List<Department> getAllDepartments() {
        return repo.findAll();
    }

    public Department getDepartmentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Department updateDepartment(Long id, Department department) {
        Department d = repo.findById(id).orElse(null);
        if (d == null) return null;

        d.setDepartmentName(department.getDepartmentName());
        d.setContactEmail(department.getContactEmail());
        d.setContactPhone(department.getContactPhone());

        return repo.save(d);
    }
}
