package com.fashiontruck.imagerecognition_BE.repository;

import com.fashiontruck.imagerecognition_BE.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {
    List<CategoryModel> findByAllowed(boolean allowed);
}
