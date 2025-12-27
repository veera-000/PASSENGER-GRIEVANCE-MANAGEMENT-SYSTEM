package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Grievance;
import com.examly.springapp.service.GrievanceService;

@RestController
@RequestMapping("/api/grievances")
public class GrievanceController {

    @Autowired
    private GrievanceService service;

    @PostMapping
    public ResponseEntity<Grievance> addGrievance(@RequestBody(required = false) Grievance grievance) {
        if (grievance == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(service.addGrievance(grievance), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Grievance>> getAllGrievances() {
        List<Grievance> list = service.getAllGrievances();
        if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getGrievanceById(@PathVariable Long id) {
        if (service.getGrievanceById(id) == null)
            return new ResponseEntity<>("Grievance not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grievance> updateGrievance(@PathVariable Long id, @RequestBody Grievance grievance) {
        Grievance updated = service.updateGrievance(id, grievance);
        if (updated == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrievance(@PathVariable Long id) {
        if (!service.deleteGrievance(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
