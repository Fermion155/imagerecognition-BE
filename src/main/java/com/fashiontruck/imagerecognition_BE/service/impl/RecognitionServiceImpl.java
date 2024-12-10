package com.fashiontruck.imagerecognition_BE.service.impl;

import com.fashiontruck.imagerecognition_BE.model.ImageStatus;
import com.fashiontruck.imagerecognition_BE.repository.CategoryRepository;
import com.fashiontruck.imagerecognition_BE.service.RecognitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecognitionServiceImpl implements RecognitionService {

    private final CategoryRepository categoryRepository;

    private final RekognitionClient rekognitionClient;

    @Override
    public ImageStatus recognizeImage(InputStream image) {
        List<String> rekLabelsAndCategories = getRekognitionLabelsAndCategories(image);

        List<String> notAllowedLabels = getLabelsBasedOnStatus(false);
        if (notAllowedLabels.stream().anyMatch(label -> rekLabelsAndCategories.contains(label))) {
            return ImageStatus.NOT_ALLOWED;
        }
        List<String> allowedLabels = getLabelsBasedOnStatus(true);
        if (allowedLabels.stream().anyMatch(label -> rekLabelsAndCategories.contains(label))) {
            return ImageStatus.ALLOWED;
        }
        return ImageStatus.NOT_RECOGNIZED;
    }

    private List<String> getLabelsBasedOnStatus(boolean allowed) {
        return categoryRepository.findByAllowed(allowed).stream()
                .map(categoryModel -> categoryModel.getLabels().stream().map(labelModel -> labelModel.getName()).toList())
                .flatMap(labelName -> labelName.stream())
                .toList();
    }

    private List<String> getRekognitionLabelsAndCategories(InputStream image) {
        SdkBytes sourceBytes = SdkBytes.fromInputStream(image);
        Image myImage = Image.builder().bytes(sourceBytes).build();
        DetectLabelsRequest detectLabelsRequest = DetectLabelsRequest.builder()
                .image(myImage)
                .minConfidence(80f)
                .maxLabels(20)
                .build();

        DetectLabelsResponse detectLabelsResponse = rekognitionClient.detectLabels(detectLabelsRequest);
        return getListOfLabelsAndCategories(detectLabelsResponse);
    }

    private List<String> getListOfLabelsAndCategories(DetectLabelsResponse detectLabelsResponse) {
        List<String> results = new ArrayList<>();
        for (Label label : detectLabelsResponse.labels()) {
            results.add(label.name());
            for (LabelCategory category : label.categories()) {
                results.add(category.name());
            }
        }
        return results;
    }
}
