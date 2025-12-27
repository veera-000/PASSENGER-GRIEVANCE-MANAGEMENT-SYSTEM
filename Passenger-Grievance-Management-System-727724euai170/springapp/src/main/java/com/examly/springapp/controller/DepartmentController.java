package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;
import com.examly.springapp.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @Autowired
    private DepartmentRepository repo;

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(service.addDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return new ResponseEntity<>(service.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department department = service.getDepartmentById(id);
        if (department == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        Department updated = service.updateDepartment(id, department);
        if (updated == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/page/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<Department>> pagination(
            @PathVariable int pageNumber,
            @PathVariable int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("departmentId"));
        Page<Department> page = repo.findAll(pageable);

        return new ResponseEntity<>(page, HttpStatus.OK);
    }
}
