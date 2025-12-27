package com.examly.springapp.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.GrievanceCategory;
import com.examly.springapp.repository.GrievanceCategoryRepository;

@Service
public class GrievanceCategoryServiceImpl implements GrievanceCategoryService {

    @Autowired
    private GrievanceCategoryRepository repo;

    public GrievanceCategory addGrievanceCategory(GrievanceCategory grievanceCategory) {
        return repo.save(grievanceCategory);
    }

    public List<GrievanceCategory> getAllGrievanceCategories() {
        return repo.findAll();
    }

    public GrievanceCategory getGrievanceCategoryById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public GrievanceCategory updateGrievanceCategory(Long id, GrievanceCategory grievanceCategory) {
        GrievanceCategory g = repo.findById(id).orElse(null);
        if (g == null) return null;
        g.setCategoryName(grievanceCategory.getCategoryName());
        g.setDescription(grievanceCategory.getDescription());
        return repo.save(g);
    }

    public List<GrievanceCategory> searchGrievanceCategories(String keyword) {
        return repo.findByCategoryNameContainingOrDescriptionContaining(keyword);
    }
}
