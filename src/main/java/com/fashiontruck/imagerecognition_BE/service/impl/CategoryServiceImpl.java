package com.fashiontruck.imagerecognition_BE.service.impl;

import com.fashiontruck.imagerecognition_BE.model.CategoryModel;
import com.fashiontruck.imagerecognition_BE.repository.CategoryRepository;
import com.fashiontruck.imagerecognition_BE.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryModel> getAllCategories() {
        return categoryRepository.findAll();
    }
}
