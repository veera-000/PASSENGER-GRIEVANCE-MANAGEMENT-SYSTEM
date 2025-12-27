package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.GrievanceCategory;

public interface GrievanceCategoryService {
    GrievanceCategory addGrievanceCategory(GrievanceCategory grievanceCategory);
    List<GrievanceCategory> getAllGrievanceCategories();
    GrievanceCategory getGrievanceCategoryById(Long id);
    GrievanceCategory updateGrievanceCategory(Long id, GrievanceCategory grievanceCategory);
    List<GrievanceCategory> searchGrievanceCategories(String keyword);
}
