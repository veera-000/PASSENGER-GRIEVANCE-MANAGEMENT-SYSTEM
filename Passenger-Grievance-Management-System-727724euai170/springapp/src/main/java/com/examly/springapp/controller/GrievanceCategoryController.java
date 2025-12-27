package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.GrievanceCategory;
import com.examly.springapp.service.GrievanceCategoryService;

@RestController
@RequestMapping("/api/grievance-categories")
public class GrievanceCategoryController {

    @Autowired
    private GrievanceCategoryService service;

    @PostMapping
    public ResponseEntity<GrievanceCategory> add(@RequestBody GrievanceCategory g) {
        return new ResponseEntity<>(service.addGrievanceCategory(g), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GrievanceCategory>> all() {
        return new ResponseEntity<>(service.getAllGrievanceCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrievanceCategory> get(@PathVariable Long id) {
        GrievanceCategory g = service.getGrievanceCategoryById(id);
        if (g == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrievanceCategory> update(@PathVariable Long id, @RequestBody GrievanceCategory g) {
        GrievanceCategory updated = service.updateGrievanceCategory(id, g);
        if (updated == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<GrievanceCategory>> search(@PathVariable String keyword) {
        return new ResponseEntity<>(service.searchGrievanceCategories(keyword), HttpStatus.OK);
    }
}
