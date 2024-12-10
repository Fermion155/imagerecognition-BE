package com.fashiontruck.imagerecognition_BE.controller;

import com.fashiontruck.imagerecognition_BE.model.CategoryModel;
import com.fashiontruck.imagerecognition_BE.model.ImageStatus;
import com.fashiontruck.imagerecognition_BE.service.CategoryService;
import com.fashiontruck.imagerecognition_BE.service.RecognitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ImageRecognitionController {

    private final CategoryService categoryService;
    private final RecognitionService recognitionService;


    @GetMapping("/categories")
    public List<CategoryModel> getAllCategories() {
        return categoryService.getAllCategories();
    }


    @PostMapping
    public ImageStatus isTheImageAllowed(@RequestParam("file") MultipartFile file) throws IOException {
        return recognitionService.recognizeImage(file.getInputStream());
    }

}
