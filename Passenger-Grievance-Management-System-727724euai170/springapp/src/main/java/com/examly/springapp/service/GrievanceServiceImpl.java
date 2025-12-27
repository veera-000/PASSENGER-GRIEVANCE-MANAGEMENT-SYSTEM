package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Grievance;
import com.examly.springapp.repository.GrievanceRepository;

@Service
public class GrievanceServiceImpl implements GrievanceService {

    @Autowired
    private GrievanceRepository repo;

    public Grievance addGrievance(Grievance grievance) {
        return repo.save(grievance);
    }

    public List<Grievance> getAllGrievances() {
        return repo.findAll();
    }

    public Grievance getGrievanceById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Grievance updateGrievance(Long id, Grievance grievance) {
        Grievance g = repo.findById(id).orElse(null);
        if (g == null) return null;
        g.setTitle(grievance.getTitle());
        g.setDescription(grievance.getDescription());
        g.setPriority(grievance.getPriority());
        return repo.save(g);
    }

    public boolean deleteGrievance(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
